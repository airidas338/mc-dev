package net.minecraft.server;
import java.util.List;
import java.util.Random;

public class bmb extends bmk {

   private boolean a;


   public bmb() {}

   public bmb(int var1, Random var2, bjb var3, EnumFacing var4) {
      super(var1);
      this.m = var4;
      this.l = var3;
   }

   protected void a(NBTTagCompound var1) {
      super.a(var1);
      var1.setBoolean("Mob", this.a);
   }

   protected void b(NBTTagCompound var1) {
      super.b(var1);
      this.a = var1.n("Mob");
   }

   public void a(bms var1, List var2, Random var3) {
      if(var1 != null) {
         ((bmh)var1).b = this;
      }

   }

   public static bmb a(List var0, Random var1, int var2, int var3, int var4, EnumFacing var5, int var6) {
      bjb var7 = bjb.a(var2, var3, var4, -4, -1, 0, 11, 8, 16, var5);
      return a(var7) && bms.a(var0, var7) == null?new bmb(var6, var1, var7, var5):null;
   }

   public boolean a(World var1, Random var2, bjb var3) {
      this.a(var1, var3, 0, 0, 0, 10, 7, 15, false, var2, blr.c());
      this.a(var1, var2, var3, bml.c, 4, 1, 0);
      byte var4 = 6;
      this.a(var1, var3, 1, var4, 1, 1, var4, 14, false, var2, blr.c());
      this.a(var1, var3, 9, var4, 1, 9, var4, 14, false, var2, blr.c());
      this.a(var1, var3, 2, var4, 1, 8, var4, 2, false, var2, blr.c());
      this.a(var1, var3, 2, var4, 14, 8, var4, 14, false, var2, blr.c());
      this.a(var1, var3, 1, 1, 1, 2, 1, 4, false, var2, blr.c());
      this.a(var1, var3, 8, 1, 1, 9, 1, 4, false, var2, blr.c());
      this.a(var1, var3, 1, 1, 1, 1, 1, 3, Blocks.k.P(), Blocks.k.P(), false);
      this.a(var1, var3, 9, 1, 1, 9, 1, 3, Blocks.k.P(), Blocks.k.P(), false);
      this.a(var1, var3, 3, 1, 8, 7, 1, 12, false, var2, blr.c());
      this.a(var1, var3, 4, 1, 9, 6, 1, 11, Blocks.k.P(), Blocks.k.P(), false);

      int var5;
      for(var5 = 3; var5 < 14; var5 += 2) {
         this.a(var1, var3, 0, 3, var5, 0, 4, var5, Blocks.bi.P(), Blocks.bi.P(), false);
         this.a(var1, var3, 10, 3, var5, 10, 4, var5, Blocks.bi.P(), Blocks.bi.P(), false);
      }

      for(var5 = 2; var5 < 9; var5 += 2) {
         this.a(var1, var3, var5, 3, 15, var5, 4, 15, Blocks.bi.P(), Blocks.bi.P(), false);
      }

      var5 = this.a(Blocks.bv, 3);
      this.a(var1, var3, 4, 1, 5, 6, 1, 7, false, var2, blr.c());
      this.a(var1, var3, 4, 2, 6, 6, 2, 7, false, var2, blr.c());
      this.a(var1, var3, 4, 3, 7, 6, 3, 7, false, var2, blr.c());

      int var6;
      for(var6 = 4; var6 <= 6; ++var6) {
         this.a(var1, Blocks.bv.a(var5), var6, 1, 4, var3);
         this.a(var1, Blocks.bv.a(var5), var6, 2, 5, var3);
         this.a(var1, Blocks.bv.a(var5), var6, 3, 6, var3);
      }

      var6 = EnumFacing.NORTH.b();
      int var7 = EnumFacing.SOUTH.b();
      int var8 = EnumFacing.EAST.b();
      int var9 = EnumFacing.WEST.b();
      if(this.m != null) {
         switch(blu.b[this.m.ordinal()]) {
         case 2:
            var6 = EnumFacing.SOUTH.b();
            var7 = EnumFacing.NORTH.b();
            break;
         case 3:
            var6 = EnumFacing.WEST.b();
            var7 = EnumFacing.EAST.b();
            var8 = EnumFacing.SOUTH.b();
            var9 = EnumFacing.NORTH.b();
            break;
         case 4:
            var6 = EnumFacing.EAST.b();
            var7 = EnumFacing.WEST.b();
            var8 = EnumFacing.SOUTH.b();
            var9 = EnumFacing.NORTH.b();
         }
      }

      this.a(var1, Blocks.bG.a(var6).a(BlockEnderPortalFrame.b, Boolean.valueOf(var2.nextFloat() > 0.9F)), 4, 3, 8, var3);
      this.a(var1, Blocks.bG.a(var6).a(BlockEnderPortalFrame.b, Boolean.valueOf(var2.nextFloat() > 0.9F)), 5, 3, 8, var3);
      this.a(var1, Blocks.bG.a(var6).a(BlockEnderPortalFrame.b, Boolean.valueOf(var2.nextFloat() > 0.9F)), 6, 3, 8, var3);
      this.a(var1, Blocks.bG.a(var7).a(BlockEnderPortalFrame.b, Boolean.valueOf(var2.nextFloat() > 0.9F)), 4, 3, 12, var3);
      this.a(var1, Blocks.bG.a(var7).a(BlockEnderPortalFrame.b, Boolean.valueOf(var2.nextFloat() > 0.9F)), 5, 3, 12, var3);
      this.a(var1, Blocks.bG.a(var7).a(BlockEnderPortalFrame.b, Boolean.valueOf(var2.nextFloat() > 0.9F)), 6, 3, 12, var3);
      this.a(var1, Blocks.bG.a(var8).a(BlockEnderPortalFrame.b, Boolean.valueOf(var2.nextFloat() > 0.9F)), 3, 3, 9, var3);
      this.a(var1, Blocks.bG.a(var8).a(BlockEnderPortalFrame.b, Boolean.valueOf(var2.nextFloat() > 0.9F)), 3, 3, 10, var3);
      this.a(var1, Blocks.bG.a(var8).a(BlockEnderPortalFrame.b, Boolean.valueOf(var2.nextFloat() > 0.9F)), 3, 3, 11, var3);
      this.a(var1, Blocks.bG.a(var9).a(BlockEnderPortalFrame.b, Boolean.valueOf(var2.nextFloat() > 0.9F)), 7, 3, 9, var3);
      this.a(var1, Blocks.bG.a(var9).a(BlockEnderPortalFrame.b, Boolean.valueOf(var2.nextFloat() > 0.9F)), 7, 3, 10, var3);
      this.a(var1, Blocks.bG.a(var9).a(BlockEnderPortalFrame.b, Boolean.valueOf(var2.nextFloat() > 0.9F)), 7, 3, 11, var3);
      if(!this.a) {
         int var12 = this.d(3);
         Location var10 = new Location(this.a(5, 6), var12, this.b(5, 6));
         if(var3.b((fd)var10)) {
            this.a = true;
            var1.a(var10, Blocks.ac.P(), 2);
            TileEntity var11 = var1.s(var10);
            if(var11 instanceof bdg) {
               ((bdg)var11).b().a("Silverfish");
            }
         }
      }

      return true;
   }
}
