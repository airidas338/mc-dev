package net.minecraft.server;
import java.util.Iterator;

public class axi extends Block {

   public static final bev a = bev.a("facing", axk.class);
   public static final bet b = bet.a("powered");


   protected axi() {
      super(Material.q);
      this.j(this.L.b().a(a, axk.e).a(b, Boolean.valueOf(false)));
      this.a(akf.d);
   }

   public AxisAlignedBB a(World var1, Location var2, IBlock var3) {
      return null;
   }

   public boolean c() {
      return false;
   }

   public boolean d() {
      return false;
   }

   public boolean a(World var1, Location var2, ej var3) {
      return var3 == ej.b && World.a((ard)var1, var2.b())?true:this.d(var1, var2.a(var3.d()));
   }

   public boolean c(World var1, Location var2) {
      return this.d(var1, var2.e())?true:(this.d(var1, var2.f())?true:(this.d(var1, var2.c())?true:(this.d(var1, var2.d())?true:(World.a((ard)var1, var2.b())?true:this.d(var1, var2.a())))));
   }

   protected boolean d(World var1, Location var2) {
      return var1.p(var2).c().t();
   }

   public IBlock a(World var1, Location var2, ej var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
      IBlock var9 = this.P().a(b, Boolean.valueOf(false));
      if(this.d(var1, var2.a(var3.d()))) {
         return var9.a(a, axk.a(var3, var8.aO()));
      } else {
         Iterator var10 = en.a.iterator();

         ej var11;
         do {
            if(!var10.hasNext()) {
               if(World.a((ard)var1, var2.b())) {
                  return var9.a(a, axk.a(ej.b, var8.aO()));
               }

               return var9;
            }

            var11 = (ej)var10.next();
         } while(var11 == var3 || !this.d(var1, var2.a(var11.d())));

         return var9.a(a, axk.a(var11, var8.aO()));
      }
   }

   public static int a(ej var0) {
      switch(axj.a[var0.ordinal()]) {
      case 1:
         return 0;
      case 2:
         return 5;
      case 3:
         return 4;
      case 4:
         return 3;
      case 5:
         return 2;
      case 6:
         return 1;
      default:
         return -1;
      }
   }

   public void a(World var1, Location var2, IBlock var3, Block var4) {
      if(this.e(var1, var2) && !this.d(var1, var2.a(((axk)var3.b(a)).c().d()))) {
         this.b(var1, var2, var3, 0);
         var1.g(var2);
      }

   }

   private boolean e(World var1, Location var2) {
      if(this.c(var1, var2)) {
         return true;
      } else {
         this.b(var1, var2, var1.p(var2), 0);
         var1.g(var2);
         return false;
      }
   }

   public void a(ard var1, Location var2) {
      float var3 = 0.1875F;
      switch(axj.b[((axk)var1.p(var2).b(a)).ordinal()]) {
      case 1:
         this.a(0.0F, 0.2F, 0.5F - var3, var3 * 2.0F, 0.8F, 0.5F + var3);
         break;
      case 2:
         this.a(1.0F - var3 * 2.0F, 0.2F, 0.5F - var3, 1.0F, 0.8F, 0.5F + var3);
         break;
      case 3:
         this.a(0.5F - var3, 0.2F, 0.0F, 0.5F + var3, 0.8F, var3 * 2.0F);
         break;
      case 4:
         this.a(0.5F - var3, 0.2F, 1.0F - var3 * 2.0F, 0.5F + var3, 0.8F, 1.0F);
         break;
      case 5:
      case 6:
         var3 = 0.25F;
         this.a(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, 0.6F, 0.5F + var3);
         break;
      case 7:
      case 8:
         var3 = 0.25F;
         this.a(0.5F - var3, 0.4F, 0.5F - var3, 0.5F + var3, 1.0F, 0.5F + var3);
      }

   }

   public boolean a(World var1, Location var2, IBlock var3, EntityHuman var4, ej var5, float var6, float var7, float var8) {
      if(var1.D) {
         return true;
      } else {
         var3 = var3.a(b);
         var1.a(var2, var3, 3);
         var1.a((double)var2.n() + 0.5D, (double)var2.o() + 0.5D, (double)var2.p() + 0.5D, "random.click", 0.3F, ((Boolean)var3.b(b)).booleanValue()?0.6F:0.5F);
         var1.c(var2, (Block)this);
         ej var9 = ((axk)var3.b(a)).c();
         var1.c(var2.a(var9.d()), (Block)this);
         return true;
      }
   }

   public void b(World var1, Location var2, IBlock var3) {
      if(((Boolean)var3.b(b)).booleanValue()) {
         var1.c(var2, (Block)this);
         ej var4 = ((axk)var3.b(a)).c();
         var1.c(var2.a(var4.d()), (Block)this);
      }

      super.b(var1, var2, var3);
   }

   public int a(ard var1, Location var2, IBlock var3, ej var4) {
      return ((Boolean)var3.b(b)).booleanValue()?15:0;
   }

   public int b(ard var1, Location var2, IBlock var3, ej var4) {
      return !((Boolean)var3.b(b)).booleanValue()?0:(((axk)var3.b(a)).c() == var4?15:0);
   }

   public boolean g() {
      return true;
   }

   public IBlock a(int var1) {
      return this.P().a(a, axk.a(var1 & 7)).a(b, Boolean.valueOf((var1 & 8) > 0));
   }

   public int c(IBlock var1) {
      byte var2 = 0;
      int var3 = var2 | ((axk)var1.b(a)).a();
      if(((Boolean)var1.b(b)).booleanValue()) {
         var3 |= 8;
      }

      return var3;
   }

   protected bed e() {
      return new bed(this, new bex[]{a, b});
   }

}
