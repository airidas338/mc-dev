package net.minecraft.server;

public enum EnumArt {

   KEBAB("KEBAB", 0, "Kebab", 16, 16, 0, 0),
   AZTEC("AZTEC", 1, "Aztec", 16, 16, 16, 0),
   ALBAN("ALBAN", 2, "Alban", 16, 16, 32, 0),
   AZTEC_2("AZTEC_2", 3, "Aztec2", 16, 16, 48, 0),
   BOMB("BOMB", 4, "Bomb", 16, 16, 64, 0),
   PLANT("PLANT", 5, "Plant", 16, 16, 80, 0),
   WASTELAND("WASTELAND", 6, "Wasteland", 16, 16, 96, 0),
   POOL("POOL", 7, "Pool", 32, 16, 0, 32),
   COURBET("COURBET", 8, "Courbet", 32, 16, 32, 32),
   SEA("SEA", 9, "Sea", 32, 16, 64, 32),
   SUNSET("SUNSET", 10, "Sunset", 32, 16, 96, 32),
   CREEBET("CREEBET", 11, "Creebet", 32, 16, 128, 32),
   WANDERER("WANDERER", 12, "Wanderer", 16, 32, 0, 64),
   GRAHAM("GRAHAM", 13, "Graham", 16, 32, 16, 64),
   MATCH("MATCH", 14, "Match", 32, 32, 0, 128),
   BUST("BUST", 15, "Bust", 32, 32, 32, 128),
   STAGE("STAGE", 16, "Stage", 32, 32, 64, 128),
   VOID("VOID", 17, "Void", 32, 32, 96, 128),
   SKULL_AND_ROSES("SKULL_AND_ROSES", 18, "SkullAndRoses", 32, 32, 128, 128),
   WITHERS("WITHER", 19, "Wither", 32, 32, 160, 128),
   FIGHTERS("FIGHTERS", 20, "Fighters", 64, 32, 0, 96),
   POINTER("POINTER", 21, "Pointer", 64, 64, 0, 192),
   PIGSCENE("PIGSCENE", 22, "Pigscene", 64, 64, 64, 192),
   BURNING_SKULL("BURNING_SKULL", 23, "BurningSkull", 64, 64, 128, 192),
   SKELETON("SKELETON", 24, "Skeleton", 64, 48, 192, 64),
   DONKEY_KONG("DONKEY_KONG", 25, "DonkeyKong", 64, 48, 192, 112);
   public static final int A = "SkullAndRoses".length();
   public final String B;
   public final int C;
   public final int D;
   public final int E;
   public final int F;
   // $FF: synthetic field
   private static final EnumArt[] G = new EnumArt[]{KEBAB, AZTEC, ALBAN, AZTEC_2, BOMB, PLANT, WASTELAND, POOL, COURBET, SEA, SUNSET, CREEBET, WANDERER, GRAHAM, MATCH, BUST, STAGE, VOID, SKULL_AND_ROSES, WITHERS, FIGHTERS, POINTER, PIGSCENE, BURNING_SKULL, SKELETON, DONKEY_KONG};


   private EnumArt(String var1, int var2, String var3, int var4, int var5, int var6, int var7) {
      this.B = var3;
      this.C = var4;
      this.D = var5;
      this.E = var6;
      this.F = var7;
   }

}
