package net.minecraft.server;



public enum EnumCreatureType {

   MONSTER("MONSTER", 0, IMonster.class, 70, Material.AIR, false, false),
   CREATURE("CREATURE", 1, EntityAnimal.class, 10, Material.AIR, true, true),
   AMBIENT("AMBIENT", 2, EntityAmbient.class, 15, Material.AIR, true, false),
   WATER_CREATURE("WATER_CREATURE", 3, EntityWaterAnimal.class, 5, Material.WATER, true, false);
   private final Class e;
   private final int f;
   private final Material g;
   private final boolean h;
   private final boolean i;
   // $FF: synthetic field
   private static final EnumCreatureType[] j = new EnumCreatureType[]{MONSTER, CREATURE, AMBIENT, WATER_CREATURE};


   private EnumCreatureType(String var1, int var2, Class var3, int var4, Material var5, boolean var6, boolean var7) {
      this.e = var3;
      this.f = var4;
      this.g = var5;
      this.h = var6;
      this.i = var7;
   }

   public Class a() {
      return this.e;
   }

   public int b() {
      return this.f;
   }

   public boolean d() {
      return this.h;
   }

   public boolean e() {
      return this.i;
   }

}
