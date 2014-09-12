package net.minecraft.server;

public class aqj extends vk {

   private final fn c;
   private final String d;
   // $FF: synthetic field
   final aqi b;


   public aqj(aqi var1, fn var2) {
      this(var1, var2.m("Properties"), var2.j("Type"), var2.f("Weight"));
   }

   public aqj(aqi var1, fn var2, String var3) {
      this(var1, var2, var3, 1);
   }

   private aqj(aqi var1, fn var2, String var3, int var4) {
      super(var4);
      this.b = var1;
      if(var3.equals("Minecart")) {
         if(var2 != null) {
            var3 = adz.a(var2.f("Type")).b();
         } else {
            var3 = "MinecartRideable";
         }
      }

      this.c = var2;
      this.d = var3;
   }

   public fn a() {
      fn var1 = new fn();
      var1.a("Properties", (gd)this.c);
      var1.a("Type", this.d);
      var1.a("Weight", this.a);
      return var1;
   }

   // $FF: synthetic method
   static String a(aqj var0) {
      return var0.d;
   }

   // $FF: synthetic method
   static fn b(aqj var0) {
      return var0.c;
   }
}
