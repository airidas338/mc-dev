package net.minecraft.server;

public class bdc extends bdf implements IUpdatePlayerListBox, we {

   private static final int[] a = new int[]{0};
   private static final int[] f = new int[]{2, 1};
   private static final int[] g = new int[]{1};
   private amj[] h = new amj[3];
   private int i;
   private int j;
   private int k;
   private int l;
   private String m;


   public int n_() {
      return this.h.length;
   }

   public amj a(int var1) {
      return this.h[var1];
   }

   public amj a(int var1, int var2) {
      if(this.h[var1] != null) {
         amj var3;
         if(this.h[var1].b <= var2) {
            var3 = this.h[var1];
            this.h[var1] = null;
            return var3;
         } else {
            var3 = this.h[var1].a(var2);
            if(this.h[var1].b == 0) {
               this.h[var1] = null;
            }

            return var3;
         }
      } else {
         return null;
      }
   }

   public amj b(int var1) {
      if(this.h[var1] != null) {
         amj var2 = this.h[var1];
         this.h[var1] = null;
         return var2;
      } else {
         return null;
      }
   }

   public void a(int var1, amj var2) {
      boolean var3 = var2 != null && var2.a(this.h[var1]) && amj.a(var2, this.h[var1]);
      this.h[var1] = var2;
      if(var2 != null && var2.b > this.p_()) {
         var2.b = this.p_();
      }

      if(var1 == 0 && !var3) {
         this.l = this.a(var2);
         this.k = 0;
         this.o_();
      }

   }

   public String d_() {
      return this.k_()?this.m:"container.furnace";
   }

   public boolean k_() {
      return this.m != null && this.m.length() > 0;
   }

   public void a(String var1) {
      this.m = var1;
   }

   public void a(NBTTagCompound var1) {
      super.a(var1);
      fv var2 = var1.c("Items", 10);
      this.h = new amj[this.n_()];

      for(int var3 = 0; var3 < var2.c(); ++var3) {
         NBTTagCompound var4 = var2.b(var3);
         byte var5 = var4.d("Slot");
         if(var5 >= 0 && var5 < this.h.length) {
            this.h[var5] = amj.a(var4);
         }
      }

      this.i = var1.e("BurnTime");
      this.k = var1.e("CookTime");
      this.l = var1.e("CookTimeTotal");
      this.j = b(this.h[1]);
      if(var1.b("CustomName", 8)) {
         this.m = var1.j("CustomName");
      }

   }

   public void b(NBTTagCompound var1) {
      super.b(var1);
      var1.a("BurnTime", (short)this.i);
      var1.a("CookTime", (short)this.k);
      var1.a("CookTimeTotal", (short)this.l);
      fv var2 = new fv();

      for(int var3 = 0; var3 < this.h.length; ++var3) {
         if(this.h[var3] != null) {
            NBTTagCompound var4 = new NBTTagCompound();
            var4.a("Slot", (byte)var3);
            this.h[var3].b(var4);
            var2.a((NBTBase)var4);
         }
      }

      var1.a("Items", (NBTBase)var2);
      if(this.k_()) {
         var1.a("CustomName", this.m);
      }

   }

   public int p_() {
      return 64;
   }

   public boolean m() {
      return this.i > 0;
   }

   public void c() {
      boolean var1 = this.m();
      boolean var2 = false;
      if(this.m()) {
         --this.i;
      }

      if(!this.b.D) {
         if(!this.m() && (this.h[1] == null || this.h[0] == null)) {
            if(!this.m() && this.k > 0) {
               this.k = MathHelper.a(this.k - 2, 0, this.l);
            }
         } else {
            if(!this.m() && this.o()) {
               this.j = this.i = b(this.h[1]);
               if(this.m()) {
                  var2 = true;
                  if(this.h[1] != null) {
                     --this.h[1].b;
                     if(this.h[1].b == 0) {
                        Item var3 = this.h[1].b().q();
                        this.h[1] = var3 != null?new amj(var3):null;
                     }
                  }
               }
            }

            if(this.m() && this.o()) {
               ++this.k;
               if(this.k == this.l) {
                  this.k = 0;
                  this.l = this.a(this.h[0]);
                  this.n();
                  var2 = true;
               }
            } else {
               this.k = 0;
            }
         }

         if(var1 != this.m()) {
            var2 = true;
            BlockFurnace.a(this.m(), this.b, this.c);
         }
      }

      if(var2) {
         this.o_();
      }

   }

   public int a(amj var1) {
      return 200;
   }

   private boolean o() {
      if(this.h[0] == null) {
         return false;
      } else {
         amj var1 = aok.a().a(this.h[0]);
         return var1 == null?false:(this.h[2] == null?true:(!this.h[2].a(var1)?false:(this.h[2].b < this.p_() && this.h[2].b < this.h[2].c()?true:this.h[2].b < var1.c())));
      }
   }

   public void n() {
      if(this.o()) {
         amj var1 = aok.a().a(this.h[0]);
         if(this.h[2] == null) {
            this.h[2] = var1.k();
         } else if(this.h[2].b() == var1.b()) {
            ++this.h[2].b;
         }

         if(this.h[0].b() == Item.a(Blocks.v) && this.h[0].i() == 1 && this.h[1] != null && this.h[1].b() == Items.aw) {
            this.h[1] = new amj(Items.ax);
         }

         --this.h[0].b;
         if(this.h[0].b <= 0) {
            this.h[0] = null;
         }

      }
   }

   public static int b(amj var0) {
      if(var0 == null) {
         return 0;
      } else {
         Item var1 = var0.b();
         if(var1 instanceof aju && Block.a(var1) != Blocks.a) {
            Block var2 = Block.a(var1);
            if(var2 == Blocks.bM) {
               return 150;
            }

            if(var2.r() == Material.WOOD) {
               return 300;
            }

            if(var2 == Blocks.cA) {
               return 16000;
            }
         }

         return var1 instanceof aks && ((aks)var1).h().equals("WOOD")?200:(var1 instanceof anm && ((anm)var1).h().equals("WOOD")?200:(var1 instanceof alo && ((alo)var1).g().equals("WOOD")?200:(var1 == Items.y?100:(var1 == Items.h?1600:(var1 == Items.ay?20000:(var1 == Item.a(Blocks.g)?100:(var1 == Items.bv?2400:0)))))));
      }
   }

   public static boolean c(amj var0) {
      return b(var0) > 0;
   }

   public boolean a(EntityHuman var1) {
      return this.b.s(this.c) != this?false:var1.e((double)this.c.n() + 0.5D, (double)this.c.o() + 0.5D, (double)this.c.p() + 0.5D) <= 64.0D;
   }

   public void b(EntityHuman var1) {}

   public void c(EntityHuman var1) {}

   public boolean b(int var1, amj var2) {
      return var1 == 2?false:(var1 != 1?true:c(var2) || aiu.c_(var2));
   }

   public int[] a(ej var1) {
      return var1 == ej.a?f:(var1 == ej.b?a:g);
   }

   public boolean a(int var1, amj var2, ej var3) {
      return this.b(var1, var2);
   }

   public boolean b(int var1, amj var2, ej var3) {
      if(var3 == ej.a && var1 == 1) {
         Item var4 = var2.b();
         if(var4 != Items.ax && var4 != Items.aw) {
            return false;
         }
      }

      return true;
   }

   public String k() {
      return "minecraft:furnace";
   }

   public aib a(ahb var1, EntityHuman var2) {
      return new aiv(var1, this);
   }

   public int a_(int var1) {
      switch(var1) {
      case 0:
         return this.i;
      case 1:
         return this.j;
      case 2:
         return this.k;
      case 3:
         return this.l;
      default:
         return 0;
      }
   }

   public void b(int var1, int var2) {
      switch(var1) {
      case 0:
         this.i = var2;
         break;
      case 1:
         this.j = var2;
         break;
      case 2:
         this.k = var2;
         break;
      case 3:
         this.l = var2;
      }

   }

   public int g() {
      return 4;
   }

   public void l() {
      for(int var1 = 0; var1 < this.h.length; ++var1) {
         this.h[var1] = null;
      }

   }

}
