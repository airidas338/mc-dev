package net.minecraft.server;

public class bql extends WorldData {

   private final WorldData b;


   public bql(WorldData var1) {
      this.b = var1;
   }

   public NBTTagCompound a() {
      return this.b.a();
   }

   public NBTTagCompound a(NBTTagCompound var1) {
      return this.b.a(var1);
   }

   public long getSeed() {
      return this.b.getSeed();
   }

   public int c() {
      return this.b.c();
   }

   public int d() {
      return this.b.d();
   }

   public int e() {
      return this.b.e();
   }

   public long getTime() {
      return this.b.getTime();
   }

   public long getDayTime() {
      return this.b.getDayTime();
   }

   public NBTTagCompound i() {
      return this.b.i();
   }

   public String getName() {
      return this.b.getName();
   }

   public int l() {
      return this.b.l();
   }

   public boolean isThundering() {
      return this.b.isThundering();
   }

   public int getThunderDuration() {
      return this.b.getThunderDuration();
   }

   public boolean hasStorm() {
      return this.b.hasStorm();
   }

   public int getWeatherDuration() {
      return this.b.getWeatherDuration();
   }

   public EnumGamemode getGameType() {
      return this.b.getGameType();
   }

   public void b(long var1) {}

   public void setDayTime(long var1) {}

   public void setSpawn(Location var1) {}

   public void setName(String var1) {}

   public void e(int var1) {}

   public void setThundering(boolean var1) {}

   public void setThunderDuration(int var1) {}

   public void setStorm(boolean var1) {}

   public void setWeatherDuration(int var1) {}

   public boolean shouldGenerateMapFeatures() {
      return this.b.shouldGenerateMapFeatures();
   }

   public boolean isHardcore() {
      return this.b.isHardcore();
   }

   public WorldType getType() {
      return this.b.getType();
   }

   public void setType(WorldType var1) {}

   public boolean allowCommands() {
      return this.b.allowCommands();
   }

   public void c(boolean var1) {}

   public boolean isInitialized() {
      return this.b.isInitialized();
   }

   public void d(boolean var1) {}

   public GameRules getGameRules() {
      return this.b.getGameRules();
   }

   public EnumDifficulty y() {
      return this.b.y();
   }

   public void a(EnumDifficulty var1) {}

   public boolean z() {
      return this.b.z();
   }

   public void e(boolean var1) {}
}
