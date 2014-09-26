package net.minecraft.server;
import java.util.Iterator;
import java.util.Random;

public class BlockBed extends BlockDirectional {

   public static final bev a = bev.a("part", atq.class);
   public static final bet b = bet.a("occupied");


   public BlockBed() {
      super(Material.CLOTH);
      this.j(this.L.b().a(a, atq.b).a(b, Boolean.valueOf(false)));
      this.j();
   }

   public boolean interact(World var1, Location var2, IBlockData var3, EntityHuman var4, EnumFacing var5, float var6, float var7, float var8) {
      if(var1.isStatic) {
         return true;
      } else {
         if(var3.b(a) != atq.a) {
            var2 = var2.a((EnumFacing)var3.b(N));
            var3 = var1.getData(var2);
            if(var3.c() != this) {
               return true;
            }
         }

         if(var1.worldProvider.e() && var1.getBiome(var2) != BiomeBase.HELL) {
            if(((Boolean)var3.b(b)).booleanValue()) {
               EntityHuman var10 = this.e(var1, var2);
               if(var10 != null) {
                  var4.b((IChatBaseComponent)(new ChatMessage("tile.bed.occupied", new Object[0])));
                  return true;
               }

               var3 = var3.a(b, Boolean.valueOf(false));
               var1.setTypeAndData(var2, var3, 4);
            }

            ahf var11 = var4.a(var2);
            if(var11 == ahf.a) {
               var3 = var3.a(b, Boolean.valueOf(true));
               var1.setTypeAndData(var2, var3, 4);
               return true;
            } else {
               if(var11 == ahf.c) {
                  var4.b((IChatBaseComponent)(new ChatMessage("tile.bed.noSleep", new Object[0])));
               } else if(var11 == ahf.f) {
                  var4.b((IChatBaseComponent)(new ChatMessage("tile.bed.notSafe", new Object[0])));
               }

               return true;
            }
         } else {
            var1.setAir(var2);
            Location var9 = var2.a(((EnumFacing)var3.b(N)).d());
            if(var1.getData(var9).c() == this) {
               var1.setAir(var9);
            }

            var1.createExplosion((Entity)null, (double)var2.n() + 0.5D, (double)var2.o() + 0.5D, (double)var2.p() + 0.5D, 5.0F, true, true);
            return true;
         }
      }
   }

   private EntityHuman e(World var1, Location var2) {
      Iterator var3 = var1.players.iterator();

      EntityHuman var4;
      do {
         if(!var3.hasNext()) {
            return null;
         }

         var4 = (EntityHuman)var3.next();
      } while(!var4.bI() || !var4.bv.equals(var2));

      return var4;
   }

   public boolean d() {
      return false;
   }

   public boolean c() {
      return false;
   }

   public void updateShape(IBlockAccess var1, Location var2) {
      this.j();
   }

   public void doPhysics(World var1, Location var2, IBlockData var3, Block var4) {
      EnumFacing var5 = (EnumFacing)var3.b(N);
      if(var3.b(a) == atq.a) {
         if(var1.getData(var2.a(var5.d())).c() != this) {
            var1.setAir(var2);
         }
      } else if(var1.getData(var2.a(var5)).c() != this) {
         var1.setAir(var2);
         if(!var1.isStatic) {
            this.b(var1, var2, var3, 0);
         }
      }

   }

   public Item a(IBlockData var1, Random var2, int var3) {
      return var1.b(a) == atq.a?null:Items.ba;
   }

   private void j() {
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.5625F, 1.0F);
   }

   public static Location a(World var0, Location var1, int var2) {
      EnumFacing var3 = (EnumFacing)var0.getData(var1).b(N);
      int var4 = var1.n();
      int var5 = var1.o();
      int var6 = var1.p();

      for(int var7 = 0; var7 <= 1; ++var7) {
         int var8 = var4 - var3.g() * var7 - 1;
         int var9 = var6 - var3.i() * var7 - 1;
         int var10 = var8 + 2;
         int var11 = var9 + 2;

         for(int var12 = var8; var12 <= var10; ++var12) {
            for(int var13 = var9; var13 <= var11; ++var13) {
               Location var14 = new Location(var12, var5, var13);
               if(d(var0, var14)) {
                  if(var2 <= 0) {
                     return var14;
                  }

                  --var2;
               }
            }
         }
      }

      return null;
   }

   protected static boolean d(World var0, Location var1) {
      return World.a((IBlockAccess)var0, var1.b()) && !var0.getData(var1).c().getMaterial().isBuildable() && !var0.getData(var1.a()).c().getMaterial().isBuildable();
   }

   public void dropNaturally(World var1, Location var2, IBlockData var3, float var4, int var5) {
      if(var3.b(a) == atq.b) {
         super.dropNaturally(var1, var2, var3, var4, 0);
      }

   }

   public int getDropData() {
      return 1;
   }

   public void a(World var1, Location var2, IBlockData var3, EntityHuman var4) {
      if(var4.abilities.canInstantlyBuild && var3.b(a) == atq.a) {
         Location var5 = var2.a(((EnumFacing)var3.b(N)).d());
         if(var1.getData(var5).c() == this) {
            var1.setAir(var5);
         }
      }

   }

   public IBlockData a(int var1) {
      EnumFacing var2 = EnumFacing.b(var1);
      return (var1 & 8) > 0?this.P().a(a, atq.a).a(N, var2).a(b, Boolean.valueOf((var1 & 4) > 0)):this.P().a(a, atq.b).a(N, var2);
   }

   public IBlockData a(IBlockData var1, IBlockAccess var2, Location var3) {
      if(var1.b(a) == atq.b) {
         IBlockData var4 = var2.getData(var3.a((EnumFacing)var1.b(N)));
         if(var4.c() == this) {
            var1 = var1.a(b, var4.b(b));
         }
      }

      return var1;
   }

   public int c(IBlockData var1) {
      byte var2 = 0;
      int var3 = var2 | ((EnumFacing)var1.b(N)).b();
      if(var1.b(a) == atq.a) {
         var3 |= 8;
         if(((Boolean)var1.b(b)).booleanValue()) {
            var3 |= 4;
         }
      }

      return var3;
   }

   protected bed e() {
      return new bed(this, new bex[]{N, a, b});
   }

}
