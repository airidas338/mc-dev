package net.minecraft.server;
import java.util.List;

public interface IChunkProvider {

   boolean isChunkLoaded(int var1, int var2);

   Chunk getOrCreateChunk(int var1, int var2);

   Chunk a(Location var1);

   void a(IChunkProvider var1, int var2, int var3);

   boolean a(IChunkProvider var1, Chunk var2, int var3, int var4);

   boolean a(boolean var1, IProgressUpdate var2);

   boolean d();

   boolean e();

   String f();

   List a(EnumCreatureType var1, Location var2);

   Location a(World var1, String var2, Location var3);

   int g();

   void a(Chunk var1, int var2, int var3);

   void c();
}
