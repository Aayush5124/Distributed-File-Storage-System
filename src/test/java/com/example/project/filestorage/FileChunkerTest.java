package com.example.project.filestorage;

import com.example.security.EncryptionUtils;
import org.junit.jupiter.api.Test;

import javax.crypto.SecretKey;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class FileChunkerTest {
    @Test
    void testChunkFile() throws Exception {
        SecretKey key = EncryptionUtils.generateKey();
        Path filePath = Path.of("testfile.txt");
        FileChunker.chunkFile(filePath, 1024 * 1024, key);
        // Add assertions to verify chunks are created
    }
}