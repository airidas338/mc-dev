package net.minecraft.server;
import java.util.Random;

public class BlockTallPlant extends BlockPlant implements atz {

   public static final bev a = bev.a("variant", avk.class);
   public static final bev b = bev.a("half", avj.class);


   public BlockTallPlant() {
      super(Material.REPLACAEBLE_PLAN);
      this.j(this.L.b().a(a, avk.a).a(b, avj.b));
      this.c(0.0F);
      this.a(h);
      this.c("doublePlant");
   }

   public void a(IBlockAccess var1, Location var2) {
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public avk e(IBlockAccess var1, Location var2) {
      IBlockData var3 = var1.getData(var2);
      if(var3.c() == this) {
         var3 = this.a(var3, var1, var2);
         return (avk)var3.b(a);
      } else {
         return avk.d;
      }
   }

   public boolean canPlace(World var1, Location var2) {
      return super.canPlace(var1, var2) && var1.isEmpty(var2.a());
   }

   public boolean f(World var1, Location var2) {
      IBlockData var3 = var1.getData(var2);
      if(var3.c() != this) {
         return true;
      } else {
         avk var4 = (avk)this.a(var3, var1, var2).b(a);
         return var4 == avk.d || var4 == avk.c;
      }
   }

   protected void e(World var1, Location var2, IBlockData var3) {
      if(!this.f(var1, var2, var3)) {
         boolean var4 = var3.b(b) == avj.a;
         Location var5 = var4?var2:var2.a();
         Location var6 = var4?var2.b():var2;
         Object var7 = var4?this:var1.getData(var5).c();
         Object var8 = var4?var1.getData(var6).c():this;
         if(var7 == this) {
            var1.a(var5, Blocks.AIR.P(), 3);
         }

         if(var8 == this) {
            var1.a(var6, Blocks.AIR.P(), 3);
            if(!var4) {
               this.b(var1, var6, var3, 0);
            }
         }

      }
   }

   public boolean f(World var1, Location var2, IBlockData var3) {
      if(var3.b(b) == avj.a) {
         return var1.getData(var2.b()).c() == this;
      } else {
         IBlockData var4 = var1.getData(var2.a());
         return var4.c() == this && super.f(var1, var2, var4);
      }
   }

   public Item a(IBlockData var1, Random var2, int var3) {
      if(var1.b(b) == avj.a) {
         return null;
      } else {
         avk var4 = (avk)var1.b(a);
         return var4 == avk.d?null:(var4 == avk.c?(var2.nextInt(8) == 0?Items.N:null):Item.a((Block)this));
      }
   }

   public int a(IBlockData var1) {
      return var1.b(b) != avj.a && var1.b(a) != avk.c?((avk)var1.b(a)).a():0;
   }

   public void a(World var1, Location var2, avk var3, int var4) {
      var1.a(var2, this.P().a(b, avj.b).a(a, var3), var4);
      var1.a(var2.a(), this.P().a(b, avj.a), var4);
   }

   public void a(World var1, Location var2, IBlockData var3, EntityLiving var4, ItemStack var5) {
      var1.a(var2.a(), this.P().a(b, avj.a), 2);
   }

   public void a(World var1, EntityHuman var2, Location var3, IBlockData var4, TileEntity var5) {
      if(var1.isStatic || var2.bY() == null || var2.bY().b() != Items.be || var4.b(b) != avj.b || !this.b(var1, var3, var4, var2)) {
         super.a(var1, var2, var3, var4, var5);
      }
   }

   public void a(World var1, Location var2, IBlockData var3, EntityHuman var4) {
      if(var3.b(b) == avj.a) {
         if(var1.getData(var2.b()).c() == this) {
            if(!var4.by.canInstantlyBuild) {
               IBlockData var5 = var1.getData(var2.b());
               avk var6 = (avk)var5.b(a);
               if(var6 != avk.d && var6 != avk.c) {
                  var1.b(var2.b(), true);
               } else if(!var1.isStatic) {
                  if(var4.bY() != null && var4.bY().b() == Items.be) {
                     this.b(var1, var2, var5, var4);
                     var1.g(var2.b());
                  } else {
                     var1.b(var2.b(), true);
                  }
               } else {
                  var1.g(var2.b());
               }
            } else {
               var1.g(var2.b());
            }
         }
      } else if(var4.by.canInstantlyBuild && var1.getData(var2.a()).c() == this) {
         var1.a(var2.a(), Blocks.AIR.P(), 2);
      }

      super.a(var1, var2, var3, var4);
   }

   private boolean b(World var1, Location var2, IBlockData var3, EntityHuman var4) {
      avk var5 = (avk)var3.b(a);
      if(var5 != avk.d && var5 != avk.c) {
         return false;
      } else {
         var4.b(StatisticList.H[Block.getId((Block)this)]);
         int var6 = (var5 == avk.c?EnumFoliage.b:EnumFoliage.c).a();
         a(var1, var2, new ItemStack(Blocks.LONG_GRASS, 2, var6));
         return true;
      }
   }

   public int j(World var1, Location var2) {
      return this.e(var1, var2).a();
   }

   public boolean a(World var1, Location var2, IBlockData var3, boolean var4) {
      avk var5 = this.e(var1, var2);
      return var5 != avk.c && var5 != avk.d;
   }

   public boolean a(World var1, Random var2, Location var3, IBlockData var4) {
      return true;
   }

   public void b(World var1, Random var2, Location var3, IBlockData var4) {
      a(var1, var3, new ItemStack(this, 1, this.e(var1, var3).a()));
   }

   public IBlockData a(int var1) {
      return (var1 & 8) > 0?this.P().a(b, avj.a):this.P().a(b, avj.b).a(a, avk.a(var1 & 7));
   }

   public IBlockData a(IBlockData var1, IBlockAccess var2, Location var3) {
      if(var1.b(b) == avj.a) {
         IBlockData var4 = var2.getData(var3.b());
         if(var4.c() == this) {
            var1 = var1.a(a, var4.b(a));
         }
      }

      return var1;
   }

   public int c(IBlockData var1) {
      return var1.b(b) == avj.a?8:((avk)var1.b(a)).a();
   }

   protected bed e() {
      return new bed(this, new bex[]{b, a});
   }

}
