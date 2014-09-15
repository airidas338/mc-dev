package net.minecraft.server;

import java.util.List;

public interface IChunkProvider {

    boolean isChunkLoaded(int var1, int var2);

    Chunk getOrCreateChunk(int var1, int var2);

    Chunk getChunkAt(Location var1);

    void getChunkAt(IChunkProvider var1, int var2, int var3);

    boolean a(IChunkProvider var1, Chunk var2, int var3, int var4);

    boolean saveChunks(boolean var1, IProgressUpdate var2);

    boolean unloadChunks();

    boolean canSave();

    String getName();

    List getMobsFor(EnumCreatureType var1, Location var2);

    Location findNearestMapFeature(World var1, String var2, Location var3);

    int getLoadedChunks();

    void recreateStructures(Chunk var1, int var2, int var3);

    void c();
}
