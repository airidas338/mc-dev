package net.minecraft.server;


public class ajn extends alq {

   private static final int[] k = new int[]{11, 16, 15, 13};
   public static final String[] a = new String[]{"minecraft:items/empty_armor_slot_helmet", "minecraft:items/empty_armor_slot_chestplate", "minecraft:items/empty_armor_slot_leggings", "minecraft:items/empty_armor_slot_boots"};
   private static final eo l = new ajo();
   public final int b;
   public final int c;
   public final int d;
   private final ajp m;


   public ajn(ajp var1, int var2, int var3) {
      this.m = var1;
      this.b = var3;
      this.d = var2;
      this.c = var1.b(var3);
      this.d(var1.a(var3));
      this.h = 1;
      this.a(akf.j);
      ave.M.a(this, l);
   }

   public int b() {
      return this.m.a();
   }

   public ajp w_() {
      return this.m;
   }

   public boolean d_(amj var1) {
      return this.m != ajp.a?false:(!var1.n()?false:(!var1.o().b("display", 10)?false:var1.o().m("display").b("color", 3)));
   }

   public int b(amj var1) {
      if(this.m != ajp.a) {
         return -1;
      } else {
         fn var2 = var1.o();
         if(var2 != null) {
            fn var3 = var2.m("display");
            if(var3 != null && var3.b("color", 3)) {
               return var3.f("color");
            }
         }

         return 10511680;
      }
   }

   public void c(amj var1) {
      if(this.m == ajp.a) {
         fn var2 = var1.o();
         if(var2 != null) {
            fn var3 = var2.m("display");
            if(var3.c("color")) {
               var3.o("color");
            }

         }
      }
   }

   public void b(amj var1, int var2) {
      if(this.m != ajp.a) {
         throw new UnsupportedOperationException("Can\'t dye non-leather!");
      } else {
         fn var3 = var1.o();
         if(var3 == null) {
            var3 = new fn();
            var1.d(var3);
         }

         fn var4 = var3.m("display");
         if(!var3.b("display", 10)) {
            var3.a("display", (gd)var4);
         }

         var4.a("color", var2);
      }
   }

   public boolean a(amj var1, amj var2) {
      return this.m.b() == var2.b()?true:super.a(var1, var2);
   }

   public amj a(amj var1, World var2, EntityHuman var3) {
      int var4 = EntityInsentient.c(var1) - 1;
      amj var5 = var3.q(var4);
      if(var5 == null) {
         var3.c(var4, var1.k());
         var1.b = 0;
      }

      return var1;
   }

   // $FF: synthetic method
   static int[] d() {
      return k;
   }

}
