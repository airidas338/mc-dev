package net.minecraft.server;
import java.util.concurrent.Callable;

public class WorldData {

   public static final EnumDifficulty a = EnumDifficulty.NORMAL;
   private long seed;
   private WorldType type;
   private String generatorOptions;
   private int spawnX;
   private int spawnY;
   private int spawnZ;
   private long time;
   private long dayTime;
   private long lastPlayed;
   private long sizeOnDisk;
   private NBTTagCompound playerData;
   private int dimension;
   private String name;
   private int version;
   private int clearWeatherTime;
   private boolean isRaining;
   private int rainTicks;
   private boolean isThundering;
   private int thunderTicks;
   private EnumGamemode gameType;
   private boolean useMapFeatures;
   private boolean hardcore;
   private boolean allowCommands;
   private boolean initialized;
   private EnumDifficulty z;
   private boolean A;
   private double B;
   private double C;
   private double D;
   private long E;
   private double F;
   private double G;
   private double H;
   private int I;
   private int J;
   private GameRules gameRules;


   protected WorldData() {
      this.type = WorldType.NORMAL;
      this.generatorOptions = "";
      this.B = 0.0D;
      this.C = 0.0D;
      this.D = 6.0E7D;
      this.E = 0L;
      this.F = 0.0D;
      this.G = 5.0D;
      this.H = 0.2D;
      this.I = 5;
      this.J = 15;
      this.gameRules = new GameRules();
   }

   public WorldData(NBTTagCompound var1) {
      this.type = WorldType.NORMAL;
      this.generatorOptions = "";
      this.B = 0.0D;
      this.C = 0.0D;
      this.D = 6.0E7D;
      this.E = 0L;
      this.F = 0.0D;
      this.G = 5.0D;
      this.H = 0.2D;
      this.I = 5;
      this.J = 15;
      this.gameRules = new GameRules();
      this.seed = var1.getLong("RandomSeed");
      if(var1.hasKeyOfType("generatorName", 8)) {
         String var2 = var1.getString("generatorName");
         this.type = WorldType.getType(var2);
         if(this.type == null) {
            this.type = WorldType.NORMAL;
         } else if(this.type.f()) {
            int var3 = 0;
            if(var1.hasKeyOfType("generatorVersion", 99)) {
               var3 = var1.getInt("generatorVersion");
            }

            this.type = this.type.a(var3);
         }

         if(var1.hasKeyOfType("generatorOptions", 8)) {
            this.generatorOptions = var1.getString("generatorOptions");
         }
      }

      this.gameType = EnumGamemode.getById(var1.getInt("GameType"));
      if(var1.hasKeyOfType("MapFeatures", 99)) {
         this.useMapFeatures = var1.getBoolean("MapFeatures");
      } else {
         this.useMapFeatures = true;
      }

      this.spawnX = var1.getInt("SpawnX");
      this.spawnY = var1.getInt("SpawnY");
      this.spawnZ = var1.getInt("SpawnZ");
      this.time = var1.getLong("Time");
      if(var1.hasKeyOfType("DayTime", 99)) {
         this.dayTime = var1.getLong("DayTime");
      } else {
         this.dayTime = this.time;
      }

      this.lastPlayed = var1.getLong("LastPlayed");
      this.sizeOnDisk = var1.getLong("SizeOnDisk");
      this.name = var1.getString("LevelName");
      this.version = var1.getInt("version");
      this.clearWeatherTime = var1.getInt("clearWeatherTime");
      this.rainTicks = var1.getInt("rainTime");
      this.isRaining = var1.getBoolean("raining");
      this.thunderTicks = var1.getInt("thunderTime");
      this.isThundering = var1.getBoolean("thundering");
      this.hardcore = var1.getBoolean("hardcore");
      if(var1.hasKeyOfType("initialized", 99)) {
         this.initialized = var1.getBoolean("initialized");
      } else {
         this.initialized = true;
      }

      if(var1.hasKeyOfType("allowCommands", 99)) {
         this.allowCommands = var1.getBoolean("allowCommands");
      } else {
         this.allowCommands = this.gameType == EnumGamemode.CREATIVE;
      }

      if(var1.hasKeyOfType("Player", 10)) {
         this.playerData = var1.getCompound("Player");
         this.dimension = this.playerData.getInt("Dimension");
      }

      if(var1.hasKeyOfType("GameRules", 10)) {
         this.gameRules.a(var1.getCompound("GameRules"));
      }

      if(var1.hasKeyOfType("Difficulty", 99)) {
         this.z = EnumDifficulty.getById(var1.getByte("Difficulty"));
      }

      if(var1.hasKeyOfType("DifficultyLocked", 1)) {
         this.A = var1.getBoolean("DifficultyLocked");
      }

      if(var1.hasKeyOfType("BorderCenterX", 99)) {
         this.B = var1.getDouble("BorderCenterX");
      }

      if(var1.hasKeyOfType("BorderCenterZ", 99)) {
         this.C = var1.getDouble("BorderCenterZ");
      }

      if(var1.hasKeyOfType("BorderSize", 99)) {
         this.D = var1.getDouble("BorderSize");
      }

      if(var1.hasKeyOfType("BorderSizeLerpTime", 99)) {
         this.E = var1.getLong("BorderSizeLerpTime");
      }

      if(var1.hasKeyOfType("BorderSizeLerpTarget", 99)) {
         this.F = var1.getDouble("BorderSizeLerpTarget");
      }

      if(var1.hasKeyOfType("BorderSafeZone", 99)) {
         this.G = var1.getDouble("BorderSafeZone");
      }

      if(var1.hasKeyOfType("BorderDamagePerBlock", 99)) {
         this.H = var1.getDouble("BorderDamagePerBlock");
      }

      if(var1.hasKeyOfType("BorderWarningBlocks", 99)) {
         this.I = var1.getInt("BorderWarningBlocks");
      }

      if(var1.hasKeyOfType("BorderWarningTime", 99)) {
         this.J = var1.getInt("BorderWarningTime");
      }

   }

   public WorldData(WorldSettings var1, String var2) {
      this.type = WorldType.NORMAL;
      this.generatorOptions = "";
      this.B = 0.0D;
      this.C = 0.0D;
      this.D = 6.0E7D;
      this.E = 0L;
      this.F = 0.0D;
      this.G = 5.0D;
      this.H = 0.2D;
      this.I = 5;
      this.J = 15;
      this.gameRules = new GameRules();
      this.a(var1);
      this.name = var2;
      this.z = a;
      this.initialized = false;
   }

   public void a(WorldSettings var1) {
      this.seed = var1.d();
      this.gameType = var1.e();
      this.useMapFeatures = var1.g();
      this.hardcore = var1.f();
      this.type = var1.h();
      this.generatorOptions = var1.j();
      this.allowCommands = var1.i();
   }

   public WorldData(WorldData var1) {
      this.type = WorldType.NORMAL;
      this.generatorOptions = "";
      this.B = 0.0D;
      this.C = 0.0D;
      this.D = 6.0E7D;
      this.E = 0L;
      this.F = 0.0D;
      this.G = 5.0D;
      this.H = 0.2D;
      this.I = 5;
      this.J = 15;
      this.gameRules = new GameRules();
      this.seed = var1.seed;
      this.type = var1.type;
      this.generatorOptions = var1.generatorOptions;
      this.gameType = var1.gameType;
      this.useMapFeatures = var1.useMapFeatures;
      this.spawnX = var1.spawnX;
      this.spawnY = var1.spawnY;
      this.spawnZ = var1.spawnZ;
      this.time = var1.time;
      this.dayTime = var1.dayTime;
      this.lastPlayed = var1.lastPlayed;
      this.sizeOnDisk = var1.sizeOnDisk;
      this.playerData = var1.playerData;
      this.dimension = var1.dimension;
      this.name = var1.name;
      this.version = var1.version;
      this.rainTicks = var1.rainTicks;
      this.isRaining = var1.isRaining;
      this.thunderTicks = var1.thunderTicks;
      this.isThundering = var1.isThundering;
      this.hardcore = var1.hardcore;
      this.allowCommands = var1.allowCommands;
      this.initialized = var1.initialized;
      this.gameRules = var1.gameRules;
      this.z = var1.z;
      this.A = var1.A;
      this.B = var1.B;
      this.C = var1.C;
      this.D = var1.D;
      this.E = var1.E;
      this.F = var1.F;
      this.G = var1.G;
      this.H = var1.H;
      this.J = var1.J;
      this.I = var1.I;
   }

   public NBTTagCompound a() {
      NBTTagCompound var1 = new NBTTagCompound();
      this.a(var1, this.playerData);
      return var1;
   }

   public NBTTagCompound a(NBTTagCompound var1) {
      NBTTagCompound var2 = new NBTTagCompound();
      this.a(var2, var1);
      return var2;
   }

   private void a(NBTTagCompound var1, NBTTagCompound var2) {
      var1.setLong("RandomSeed", this.seed);
      var1.setString("generatorName", this.type.name());
      var1.setInt("generatorVersion", this.type.d());
      var1.setString("generatorOptions", this.generatorOptions);
      var1.setInt("GameType", this.gameType.a());
      var1.setBoolean("MapFeatures", this.useMapFeatures);
      var1.setInt("SpawnX", this.spawnX);
      var1.setInt("SpawnY", this.spawnY);
      var1.setInt("SpawnZ", this.spawnZ);
      var1.setLong("Time", this.time);
      var1.setLong("DayTime", this.dayTime);
      var1.setLong("SizeOnDisk", this.sizeOnDisk);
      var1.setLong("LastPlayed", MinecraftServer.ax());
      var1.setString("LevelName", this.name);
      var1.setInt("version", this.version);
      var1.setInt("clearWeatherTime", this.clearWeatherTime);
      var1.setInt("rainTime", this.rainTicks);
      var1.setBoolean("raining", this.isRaining);
      var1.setInt("thunderTime", this.thunderTicks);
      var1.setBoolean("thundering", this.isThundering);
      var1.setBoolean("hardcore", this.hardcore);
      var1.setBoolean("allowCommands", this.allowCommands);
      var1.setBoolean("initialized", this.initialized);
      var1.setDouble("BorderCenterX", this.B);
      var1.setDouble("BorderCenterZ", this.C);
      var1.setDouble("BorderSize", this.D);
      var1.setLong("BorderSizeLerpTime", this.E);
      var1.setDouble("BorderSafeZone", this.G);
      var1.setDouble("BorderDamagePerBlock", this.H);
      var1.setDouble("BorderSizeLerpTarget", this.F);
      var1.setDouble("BorderWarningBlocks", (double)this.I);
      var1.setDouble("BorderWarningTime", (double)this.J);
      if(this.z != null) {
         var1.setByte("Difficulty", (byte)this.z.a());
      }

      var1.setBoolean("DifficultyLocked", this.A);
      var1.set("GameRules", (NBTBase)this.gameRules.a());
      if(var2 != null) {
         var1.set("Player", (NBTBase)var2);
      }

   }

   public long getSeed() {
      return this.seed;
   }

   public int c() {
      return this.spawnX;
   }

   public int d() {
      return this.spawnY;
   }

   public int e() {
      return this.spawnZ;
   }

   public long getTime() {
      return this.time;
   }

   public long getDayTime() {
      return this.dayTime;
   }

   public NBTTagCompound i() {
      return this.playerData;
   }

   public void b(long var1) {
      this.time = var1;
   }

   public void setDayTime(long var1) {
      this.dayTime = var1;
   }

   public void setSpawn(Location var1) {
      this.spawnX = var1.n();
      this.spawnY = var1.o();
      this.spawnZ = var1.p();
   }

   public String getName() {
      return this.name;
   }

   public void setName(String var1) {
      this.name = var1;
   }

   public int l() {
      return this.version;
   }

   public void e(int var1) {
      this.version = var1;
   }

   public int getClearWeatherDuration() {
      return this.clearWeatherTime;
   }

   public void i(int var1) {
      this.clearWeatherTime = var1;
   }

   public boolean isThundering() {
      return this.isThundering;
   }

   public void setThundering(boolean var1) {
      this.isThundering = var1;
   }

   public int getThunderDuration() {
      return this.thunderTicks;
   }

   public void setThunderDuration(int var1) {
      this.thunderTicks = var1;
   }

   public boolean hasStorm() {
      return this.isRaining;
   }

   public void setStorm(boolean var1) {
      this.isRaining = var1;
   }

   public int getWeatherDuration() {
      return this.rainTicks;
   }

   public void setWeatherDuration(int var1) {
      this.rainTicks = var1;
   }

   public EnumGamemode getGameType() {
      return this.gameType;
   }

   public boolean shouldGenerateMapFeatures() {
      return this.useMapFeatures;
   }

   public void f(boolean var1) {
      this.useMapFeatures = var1;
   }

   public void setGameType(EnumGamemode var1) {
      this.gameType = var1;
   }

   public boolean isHardcore() {
      return this.hardcore;
   }

   public void g(boolean var1) {
      this.hardcore = var1;
   }

   public WorldType getType() {
      return this.type;
   }

   public void setType(WorldType var1) {
      this.type = var1;
   }

   public String getGeneratorOptions() {
      return this.generatorOptions;
   }

   public boolean allowCommands() {
      return this.allowCommands;
   }

   public void c(boolean var1) {
      this.allowCommands = var1;
   }

   public boolean isInitialized() {
      return this.initialized;
   }

   public void d(boolean var1) {
      this.initialized = var1;
   }

   public GameRules getGameRules() {
      return this.gameRules;
   }

   public double C() {
      return this.B;
   }

   public double D() {
      return this.C;
   }

   public double E() {
      return this.D;
   }

   public void a(double var1) {
      this.D = var1;
   }

   public long F() {
      return this.E;
   }

   public void e(long var1) {
      this.E = var1;
   }

   public double G() {
      return this.F;
   }

   public void b(double var1) {
      this.F = var1;
   }

   public void c(double var1) {
      this.C = var1;
   }

   public void d(double var1) {
      this.B = var1;
   }

   public double H() {
      return this.G;
   }

   public void e(double var1) {
      this.G = var1;
   }

   public double I() {
      return this.H;
   }

   public void f(double var1) {
      this.H = var1;
   }

   public int J() {
      return this.I;
   }

   public int K() {
      return this.J;
   }

   public void j(int var1) {
      this.I = var1;
   }

   public void k(int var1) {
      this.J = var1;
   }

   public EnumDifficulty y() {
      return this.z;
   }

   public void a(EnumDifficulty var1) {
      this.z = var1;
   }

   public boolean z() {
      return this.A;
   }

   public void e(boolean var1) {
      this.A = var1;
   }

   public void a(CrashReportSystemDetails var1) {
      var1.a("Level seed", (Callable)(new bqp(this)));
      var1.a("Level generator", (Callable)(new bqq(this)));
      var1.a("Level generator options", (Callable)(new bqr(this)));
      var1.a("Level spawn location", (Callable)(new bqs(this)));
      var1.a("Level time", (Callable)(new bqt(this)));
      var1.a("Level dimension", (Callable)(new bqu(this)));
      var1.a("Level storage version", (Callable)(new bqv(this)));
      var1.a("Level weather", (Callable)(new bqw(this)));
      var1.a("Level game mode", (Callable)(new bqx(this)));
   }

   // $FF: synthetic method
   static WorldType a(WorldData var0) {
      return var0.type;
   }

   // $FF: synthetic method
   static boolean b(WorldData var0) {
      return var0.useMapFeatures;
   }

   // $FF: synthetic method
   static String c(WorldData var0) {
      return var0.generatorOptions;
   }

   // $FF: synthetic method
   static int d(WorldData var0) {
      return var0.spawnX;
   }

   // $FF: synthetic method
   static int e(WorldData var0) {
      return var0.spawnY;
   }

   // $FF: synthetic method
   static int f(WorldData var0) {
      return var0.spawnZ;
   }

   // $FF: synthetic method
   static long g(WorldData var0) {
      return var0.time;
   }

   // $FF: synthetic method
   static long h(WorldData var0) {
      return var0.dayTime;
   }

   // $FF: synthetic method
   static int i(WorldData var0) {
      return var0.dimension;
   }

   // $FF: synthetic method
   static int j(WorldData var0) {
      return var0.version;
   }

   // $FF: synthetic method
   static int k(WorldData var0) {
      return var0.rainTicks;
   }

   // $FF: synthetic method
   static boolean l(WorldData var0) {
      return var0.isRaining;
   }

   // $FF: synthetic method
   static int m(WorldData var0) {
      return var0.thunderTicks;
   }

   // $FF: synthetic method
   static boolean n(WorldData var0) {
      return var0.isThundering;
   }

   // $FF: synthetic method
   static EnumGamemode o(WorldData var0) {
      return var0.gameType;
   }

   // $FF: synthetic method
   static boolean p(WorldData var0) {
      return var0.hardcore;
   }

   // $FF: synthetic method
   static boolean q(WorldData var0) {
      return var0.allowCommands;
   }

}
