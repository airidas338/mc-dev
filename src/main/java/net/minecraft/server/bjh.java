package net.minecraft.server;
import java.util.List;
import java.util.Random;

public class bjh extends bms {

   private EnumFacing a;
   private boolean b;


   public bjh() {}

   protected void a(NBTTagCompound var1) {
      var1.setBoolean("tf", this.b);
      var1.setInt("D", this.a.b());
   }

   protected void b(NBTTagCompound var1) {
      this.b = var1.getBoolean("tf");
      this.a = EnumFacing.b(var1.getInt("D"));
   }

   public bjh(int var1, Random var2, bjb var3, EnumFacing var4) {
      super(var1);
      this.a = var4;
      this.l = var3;
      this.b = var3.d() > 3;
   }

   public static bjb a(List var0, Random var1, int var2, int var3, int var4, EnumFacing var5) {
      bjb var6 = new bjb(var2, var3, var4, var2, var3 + 2, var4);
      if(var1.nextInt(4) == 0) {
         var6.e += 4;
      }

      switch(bjf.a[var5.ordinal()]) {
      case 1:
         var6.a = var2 - 1;
         var6.d = var2 + 3;
         var6.c = var4 - 4;
         break;
      case 2:
         var6.a = var2 - 1;
         var6.d = var2 + 3;
         var6.f = var4 + 4;
         break;
      case 3:
         var6.a = var2 - 4;
         var6.c = var4 - 1;
         var6.f = var4 + 3;
         break;
      case 4:
         var6.d = var2 + 4;
         var6.c = var4 - 1;
         var6.f = var4 + 3;
      }

      return bms.a(var0, var6) != null?null:var6;
   }

   public void a(bms var1, List var2, Random var3) {
      int var4 = this.d();
      switch(bjf.a[this.a.ordinal()]) {
      case 1:
         bje.a(var1, var2, var3, this.l.a + 1, this.l.b, this.l.c - 1, EnumFacing.NORTH, var4);
         bje.a(var1, var2, var3, this.l.a - 1, this.l.b, this.l.c + 1, EnumFacing.WEST, var4);
         bje.a(var1, var2, var3, this.l.d + 1, this.l.b, this.l.c + 1, EnumFacing.EAST, var4);
         break;
      case 2:
         bje.a(var1, var2, var3, this.l.a + 1, this.l.b, this.l.f + 1, EnumFacing.SOUTH, var4);
         bje.a(var1, var2, var3, this.l.a - 1, this.l.b, this.l.c + 1, EnumFacing.WEST, var4);
         bje.a(var1, var2, var3, this.l.d + 1, this.l.b, this.l.c + 1, EnumFacing.EAST, var4);
         break;
      case 3:
         bje.a(var1, var2, var3, this.l.a + 1, this.l.b, this.l.c - 1, EnumFacing.NORTH, var4);
         bje.a(var1, var2, var3, this.l.a + 1, this.l.b, this.l.f + 1, EnumFacing.SOUTH, var4);
         bje.a(var1, var2, var3, this.l.a - 1, this.l.b, this.l.c + 1, EnumFacing.WEST, var4);
         break;
      case 4:
         bje.a(var1, var2, var3, this.l.a + 1, this.l.b, this.l.c - 1, EnumFacing.NORTH, var4);
         bje.a(var1, var2, var3, this.l.a + 1, this.l.b, this.l.f + 1, EnumFacing.SOUTH, var4);
         bje.a(var1, var2, var3, this.l.d + 1, this.l.b, this.l.c + 1, EnumFacing.EAST, var4);
      }

      if(this.b) {
         if(var3.nextBoolean()) {
            bje.a(var1, var2, var3, this.l.a + 1, this.l.b + 3 + 1, this.l.c - 1, EnumFacing.NORTH, var4);
         }

         if(var3.nextBoolean()) {
            bje.a(var1, var2, var3, this.l.a - 1, this.l.b + 3 + 1, this.l.c + 1, EnumFacing.WEST, var4);
         }

         if(var3.nextBoolean()) {
            bje.a(var1, var2, var3, this.l.d + 1, this.l.b + 3 + 1, this.l.c + 1, EnumFacing.EAST, var4);
         }

         if(var3.nextBoolean()) {
            bje.a(var1, var2, var3, this.l.a + 1, this.l.b + 3 + 1, this.l.f + 1, EnumFacing.SOUTH, var4);
         }
      }

   }

   public boolean a(World var1, Random var2, bjb var3) {
      if(this.a(var1, var3)) {
         return false;
      } else {
         if(this.b) {
            this.a(var1, var3, this.l.a + 1, this.l.b, this.l.c, this.l.d - 1, this.l.b + 3 - 1, this.l.f, Blocks.AIR.P(), Blocks.AIR.P(), false);
            this.a(var1, var3, this.l.a, this.l.b, this.l.c + 1, this.l.d, this.l.b + 3 - 1, this.l.f - 1, Blocks.AIR.P(), Blocks.AIR.P(), false);
            this.a(var1, var3, this.l.a + 1, this.l.e - 2, this.l.c, this.l.d - 1, this.l.e, this.l.f, Blocks.AIR.P(), Blocks.AIR.P(), false);
            this.a(var1, var3, this.l.a, this.l.e - 2, this.l.c + 1, this.l.d, this.l.e, this.l.f - 1, Blocks.AIR.P(), Blocks.AIR.P(), false);
            this.a(var1, var3, this.l.a + 1, this.l.b + 3, this.l.c + 1, this.l.d - 1, this.l.b + 3, this.l.f - 1, Blocks.AIR.P(), Blocks.AIR.P(), false);
         } else {
            this.a(var1, var3, this.l.a + 1, this.l.b, this.l.c, this.l.d - 1, this.l.e, this.l.f, Blocks.AIR.P(), Blocks.AIR.P(), false);
            this.a(var1, var3, this.l.a, this.l.b, this.l.c + 1, this.l.d, this.l.e, this.l.f - 1, Blocks.AIR.P(), Blocks.AIR.P(), false);
         }

         this.a(var1, var3, this.l.a + 1, this.l.b, this.l.c + 1, this.l.a + 1, this.l.e, this.l.c + 1, Blocks.WOOD.P(), Blocks.AIR.P(), false);
         this.a(var1, var3, this.l.a + 1, this.l.b, this.l.f - 1, this.l.a + 1, this.l.e, this.l.f - 1, Blocks.WOOD.P(), Blocks.AIR.P(), false);
         this.a(var1, var3, this.l.d - 1, this.l.b, this.l.c + 1, this.l.d - 1, this.l.e, this.l.c + 1, Blocks.WOOD.P(), Blocks.AIR.P(), false);
         this.a(var1, var3, this.l.d - 1, this.l.b, this.l.f - 1, this.l.d - 1, this.l.e, this.l.f - 1, Blocks.WOOD.P(), Blocks.AIR.P(), false);

         for(int var4 = this.l.a; var4 <= this.l.d; ++var4) {
            for(int var5 = this.l.c; var5 <= this.l.f; ++var5) {
               if(this.a(var1, var4, this.l.b - 1, var5, var3).c().getMaterial() == Material.AIR) {
                  this.a(var1, Blocks.WOOD.P(), var4, this.l.b - 1, var5, var3);
               }
            }
         }

         return true;
      }
   }
}
