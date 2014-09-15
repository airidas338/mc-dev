package net.minecraft.server;

public class TileEntityMobSpawnerData extends vk {

   private final NBTTagCompound c;
   private final String d;
   // $FF: synthetic field
   final MobSpawnerAbstract b;


   public TileEntityMobSpawnerData(MobSpawnerAbstract var1, NBTTagCompound var2) {
      this(var1, var2.getCompound("Properties"), var2.getString("Type"), var2.getInt("Weight"));
   }

   public TileEntityMobSpawnerData(MobSpawnerAbstract var1, NBTTagCompound var2, String var3) {
      this(var1, var2, var3, 1);
   }

   private TileEntityMobSpawnerData(MobSpawnerAbstract var1, NBTTagCompound var2, String var3, int var4) {
      super(var4);
      this.b = var1;
      if(var3.equals("Minecart")) {
         if(var2 != null) {
            var3 = EnumMinecartType.a(var2.getInt("Type")).b();
         } else {
            var3 = "MinecartRideable";
         }
      }

      this.c = var2;
      this.d = var3;
   }

   public NBTTagCompound a() {
      NBTTagCompound var1 = new NBTTagCompound();
      var1.set("Properties", (NBTBase)this.c);
      var1.setString("Type", this.d);
      var1.setInt("Weight", this.a);
      return var1;
   }

   // $FF: synthetic method
   static String a(TileEntityMobSpawnerData var0) {
      return var0.d;
   }

   // $FF: synthetic method
   static NBTTagCompound b(TileEntityMobSpawnerData var0) {
      return var0.c;
   }
}
