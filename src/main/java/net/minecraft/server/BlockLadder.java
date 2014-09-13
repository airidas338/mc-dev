package net.minecraft.server;
import com.google.common.base.Predicate;

import java.util.Iterator;

public class BlockLadder extends Block {

   public static final beu a = beu.a("facing", (Predicate)en.a);


   protected BlockLadder() {
      super(Material.ORIENTABLE);
      this.j(this.L.b().a(a, EnumFacing.NORTH));
      this.a(CreativeModeTab.c);
   }

   public AxisAlignedBB a(World var1, Location var2, IBlock var3) {
      this.a(var1, var2);
      return super.a(var1, var2, var3);
   }

   public void a(IBlockAccess var1, Location var2) {
      IBlock var3 = var1.getData(var2);
      if(var3.c() == this) {
         float var4 = 0.125F;
         switch(axf.a[((EnumFacing)var3.b(a)).ordinal()]) {
         case 1:
            this.a(0.0F, 0.0F, 1.0F - var4, 1.0F, 1.0F, 1.0F);
            break;
         case 2:
            this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var4);
            break;
         case 3:
            this.a(1.0F - var4, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            break;
         case 4:
         default:
            this.a(0.0F, 0.0F, 0.0F, var4, 1.0F, 1.0F);
         }

      }
   }

   public boolean c() {
      return false;
   }

   public boolean d() {
      return false;
   }

   public boolean c(World var1, Location var2) {
      return var1.getData(var2.e()).c().t()?true:(var1.getData(var2.f()).c().t()?true:(var1.getData(var2.c()).c().t()?true:var1.getData(var2.d()).c().t()));
   }

   public IBlock a(World var1, Location var2, EnumFacing var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
      if(var3.k().c() && this.b(var1, var2, var3)) {
         return this.P().a(a, var3);
      } else {
         Iterator var9 = en.a.iterator();

         EnumFacing var10;
         do {
            if(!var9.hasNext()) {
               return this.P();
            }

            var10 = (EnumFacing)var9.next();
         } while(!this.b(var1, var2, var10));

         return this.P().a(a, var10);
      }
   }

   public void a(World var1, Location var2, IBlock var3, Block var4) {
      EnumFacing var5 = (EnumFacing)var3.b(a);
      if(!this.b(var1, var2, var5)) {
         this.b(var1, var2, var3, 0);
         var1.g(var2);
      }

      super.a(var1, var2, var3, var4);
   }

   protected boolean b(World var1, Location var2, EnumFacing var3) {
      return var1.getData(var2.a(var3.d())).c().t();
   }

   public IBlock a(int var1) {
      EnumFacing var2 = EnumFacing.a(var1);
      if(var2.k() == el.b) {
         var2 = EnumFacing.NORTH;
      }

      return this.P().a(a, var2);
   }

   public int c(IBlock var1) {
      return ((EnumFacing)var1.b(a)).a();
   }

   protected bed e() {
      return new bed(this, new bex[]{a});
   }

}
