package com.example.project.filestorage;

import com.example.project.metadata.ChunkLocation;
import com.example.project.metadata.MetadataService;
import com.example.project.node.NodeInfo;
import com.example.project.node.NodeManager;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class FileStorageSystem {
    private static final int CHUNK_SIZE = 1024; // 1KB
    private static NodeManager nodeManager = new NodeManager();
    private static MetadataService metadataService = new MetadataService();

    public static void uploadFile(Path filePath) throws IOException {
        FileChunker.chunkFile(filePath, CHUNK_SIZE);
        String fileName = filePath.getFileName().toString();
        List<ChunkLocation> chunkLocations = new ArrayList<>();
        List<Path> chunks = Files.list(filePath.getParent()).filter(p -> p.toString().startsWith(filePath.toString() + ".part")).collect(Collectors.toList());

        for (int i = 0; i < chunks.size(); i++) {
            ChunkLocation location = new ChunkLocation(selectNodeForChunk(),i);
            chunkLocations.add(location);
            // Simulate uploading chunk to selected node
            System.out.println("Uploading " + chunks.get(i) + " to " + location);
        }

        metadataService.addFileMetadata(fileName, chunkLocations);
    }

    private static String selectNodeForChunk() {
        // Simplified node selection for example
        return nodeManager.getAllNodes().stream().findFirst().map(NodeInfo::getIpAddress).orElse("unknown");
    }

    public static void main(String[] args) throws IOException {
        // Register some nodes for testing
        nodeManager.registernode("node1", new NodeInfo("192.168.1.1", 8080));
        nodeManager.registernode("node2", new NodeInfo("192.168.1.2", 8080));

        // Upload a sample file
        Path filePath = Paths.get("sample.txt");
        uploadFile(filePath);
    }
}