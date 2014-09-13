package net.minecraft.server;
import java.io.File;

public interface IDataManager {

   WorldData d();

   void c() throws ExceptionWorldConflict;

   IChunkLoader a(WorldProvider var1);

   void a(WorldData var1, NBTTagCompound var2);

   void a(WorldData var1);

   IPlayerFileData e();

   void a();

   File b();

   File a(String var1);

   String g();
}
