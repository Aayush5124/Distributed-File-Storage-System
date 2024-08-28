package com.example.project.metadata;

import java.util.List;

public class MetadataService {
    public void saveFileMetadata(String fileId, ChunkLocation[] chunkLocations) {
        // Save metadata about file chunks
    }

    public ChunkLocation[] getFileMetadata(String fileId) {
        // Retrieve metadata for a file
        return new ChunkLocation[0];
    }

    public void addFileMetadata(String fileName, List<ChunkLocation> chunkLocations) {
    }
}