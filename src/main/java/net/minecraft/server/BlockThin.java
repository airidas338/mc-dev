package net.minecraft.server;
import java.util.List;
import java.util.Random;

public class BlockThin extends Block {

   public static final bet b = bet.a("north");
   public static final bet M = bet.a("east");
   public static final bet N = bet.a("south");
   public static final bet O = bet.a("west");
   private final boolean a;


   protected BlockThin(Material var1, boolean var2) {
      super(var1);
      this.j(this.L.b().a(b, Boolean.valueOf(false)).a(M, Boolean.valueOf(false)).a(N, Boolean.valueOf(false)).a(O, Boolean.valueOf(false)));
      this.a = var2;
      this.a(CreativeModeTab.c);
   }

   public IBlockData a(IBlockData var1, IBlockAccess var2, Location var3) {
      return var1.a(b, Boolean.valueOf(this.c(var2.getData(var3.c()).c()))).a(N, Boolean.valueOf(this.c(var2.getData(var3.d()).c()))).a(O, Boolean.valueOf(this.c(var2.getData(var3.e()).c()))).a(M, Boolean.valueOf(this.c(var2.getData(var3.f()).c())));
   }

   public Item a(IBlockData var1, Random var2, int var3) {
      return !this.a?null:super.a(var1, var2, var3);
   }

   public boolean c() {
      return false;
   }

   public boolean d() {
      return false;
   }

   public void a(World var1, Location var2, IBlockData var3, AxisAlignedBB var4, List var5, Entity var6) {
      boolean var7 = this.c(var1.getData(var2.c()).c());
      boolean var8 = this.c(var1.getData(var2.d()).c());
      boolean var9 = this.c(var1.getData(var2.e()).c());
      boolean var10 = this.c(var1.getData(var2.f()).c());
      if((!var9 || !var10) && (var9 || var10 || var7 || var8)) {
         if(var9) {
            this.a(0.0F, 0.0F, 0.4375F, 0.5F, 1.0F, 0.5625F);
            super.a(var1, var2, var3, var4, var5, var6);
         } else if(var10) {
            this.a(0.5F, 0.0F, 0.4375F, 1.0F, 1.0F, 0.5625F);
            super.a(var1, var2, var3, var4, var5, var6);
         }
      } else {
         this.a(0.0F, 0.0F, 0.4375F, 1.0F, 1.0F, 0.5625F);
         super.a(var1, var2, var3, var4, var5, var6);
      }

      if((!var7 || !var8) && (var9 || var10 || var7 || var8)) {
         if(var7) {
            this.a(0.4375F, 0.0F, 0.0F, 0.5625F, 1.0F, 0.5F);
            super.a(var1, var2, var3, var4, var5, var6);
         } else if(var8) {
            this.a(0.4375F, 0.0F, 0.5F, 0.5625F, 1.0F, 1.0F);
            super.a(var1, var2, var3, var4, var5, var6);
         }
      } else {
         this.a(0.4375F, 0.0F, 0.0F, 0.5625F, 1.0F, 1.0F);
         super.a(var1, var2, var3, var4, var5, var6);
      }

   }

   public void h() {
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public void a(IBlockAccess var1, Location var2) {
      float var3 = 0.4375F;
      float var4 = 0.5625F;
      float var5 = 0.4375F;
      float var6 = 0.5625F;
      boolean var7 = this.c(var1.getData(var2.c()).c());
      boolean var8 = this.c(var1.getData(var2.d()).c());
      boolean var9 = this.c(var1.getData(var2.e()).c());
      boolean var10 = this.c(var1.getData(var2.f()).c());
      if((!var9 || !var10) && (var9 || var10 || var7 || var8)) {
         if(var9) {
            var3 = 0.0F;
         } else if(var10) {
            var4 = 1.0F;
         }
      } else {
         var3 = 0.0F;
         var4 = 1.0F;
      }

      if((!var7 || !var8) && (var9 || var10 || var7 || var8)) {
         if(var7) {
            var5 = 0.0F;
         } else if(var8) {
            var6 = 1.0F;
         }
      } else {
         var5 = 0.0F;
         var6 = 1.0F;
      }

      this.a(var3, 0.0F, var5, var4, 1.0F, var6);
   }

   public final boolean c(Block var1) {
      return var1.m() || var1 == this || var1 == Blocks.GLASS || var1 == Blocks.STAINED_GLASS || var1 == Blocks.STAINED_GLASS_PANE || var1 instanceof BlockThin;
   }

   protected boolean G() {
      return true;
   }

   public int c(IBlockData var1) {
      return 0;
   }

   protected bed e() {
      return new bed(this, new bex[]{b, M, O, N});
   }

}
