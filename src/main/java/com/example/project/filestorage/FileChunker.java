package com.example.project.filestorage;

import com.example.project.security.EncryptionUtils;


import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class FileChunker {
    public static void chunkFile(Path filePath, int chunkSize, SecretKey key) throws Exception {
        byte[] fileBytes = Files.readAllBytes(filePath);
        String encryptedData = EncryptionUtils.encrypt(new String(fileBytes), key);
        byte[] encryptedBytes = encryptedData.getBytes();

        int totalChunks = (int) Math.ceil((double) encryptedBytes.length / chunkSize);
        for (int i = 0; i < totalChunks; i++) {
            int start = i * chunkSize;
            int end = Math.min(start + chunkSize, encryptedBytes.length);
            byte[] chunk = Arrays.copyOfRange(encryptedBytes, start, end);
            Path chunkPath = Path.of(filePath.toString() + ".part" + i);
            Files.write(chunkPath, chunk);
        }
    }

    public static void chunkFile(Path filePath, int chunkSize) {

    }
}
