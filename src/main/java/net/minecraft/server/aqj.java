package net.minecraft.server;

public class aqj extends vk {

   private final NBTTagCompound c;
   private final String d;
   // $FF: synthetic field
   final aqi b;


   public aqj(aqi var1, NBTTagCompound var2) {
      this(var1, var2.m("Properties"), var2.j("Type"), var2.f("Weight"));
   }

   public aqj(aqi var1, NBTTagCompound var2, String var3) {
      this(var1, var2, var3, 1);
   }

   private aqj(aqi var1, NBTTagCompound var2, String var3, int var4) {
      super(var4);
      this.b = var1;
      if(var3.equals("Minecart")) {
         if(var2 != null) {
            var3 = EnumMinecartType.a(var2.f("Type")).b();
         } else {
            var3 = "MinecartRideable";
         }
      }

      this.c = var2;
      this.d = var3;
   }

   public NBTTagCompound a() {
      NBTTagCompound var1 = new NBTTagCompound();
      var1.a("Properties", (NBTBase)this.c);
      var1.a("Type", this.d);
      var1.a("Weight", this.a);
      return var1;
   }

   // $FF: synthetic method
   static String a(aqj var0) {
      return var0.d;
   }

   // $FF: synthetic method
   static NBTTagCompound b(aqj var0) {
      return var0.c;
   }
}
