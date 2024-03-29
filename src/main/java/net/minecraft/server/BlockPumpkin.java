package net.minecraft.server;


public class BlockPumpkin extends BlockDirectional {

   private bek a;
   private bek b;
   private bek M;
   private bek O;


   protected BlockPumpkin() {
      super(Material.PUMPKIN);
      this.j(this.L.b().a(N, EnumFacing.NORTH));
      this.a(true);
      this.a(CreativeModeTab.b);
   }

   public void onPlace(World var1, Location var2, IBlockData var3) {
      super.onPlace(var1, var2, var3);
      this.e(var1, var2);
   }

   public boolean d(World var1, Location var2) {
      return this.j().a(var1, var2) != null || this.S().a(var1, var2) != null;
   }

   private void e(World var1, Location var2) {
      bem var3;
      int var4;
      int var6;
      if((var3 = this.l().a(var1, var2)) != null) {
         for(var4 = 0; var4 < this.l().b(); ++var4) {
            bei var5 = var3.a(0, var4, 0);
            var1.setTypeAndData(var5.d(), Blocks.AIR.P(), 2);
         }

         EntitySnowman var9 = new EntitySnowman(var1);
         Location var10 = var3.a(0, 2, 0).d();
         var9.setPositionRotation((double)var10.n() + 0.5D, (double)var10.o() + 0.05D, (double)var10.p() + 0.5D, 0.0F, 0.0F);
         var1.addEntity((Entity)var9);

         for(var6 = 0; var6 < 120; ++var6) {
            var1.a(EnumParticleEffect.G, (double)var10.n() + var1.random.nextDouble(), (double)var10.o() + var1.random.nextDouble() * 2.5D, (double)var10.p() + var1.random.nextDouble(), 0.0D, 0.0D, 0.0D, new int[0]);
         }

         for(var6 = 0; var6 < this.l().b(); ++var6) {
            bei var7 = var3.a(0, var6, 0);
            var1.update(var7.d(), Blocks.AIR);
         }
      } else if((var3 = this.T().a(var1, var2)) != null) {
         for(var4 = 0; var4 < this.T().c(); ++var4) {
            for(int var11 = 0; var11 < this.T().b(); ++var11) {
               var1.setTypeAndData(var3.a(var4, var11, 0).d(), Blocks.AIR.P(), 2);
            }
         }

         Location var12 = var3.a(1, 2, 0).d();
         EntityIronGolem var13 = new EntityIronGolem(var1);
         var13.l(true);
         var13.setPositionRotation((double)var12.n() + 0.5D, (double)var12.o() + 0.05D, (double)var12.p() + 0.5D, 0.0F, 0.0F);
         var1.addEntity((Entity)var13);

         for(var6 = 0; var6 < 120; ++var6) {
            var1.a(EnumParticleEffect.F, (double)var12.n() + var1.random.nextDouble(), (double)var12.o() + var1.random.nextDouble() * 3.9D, (double)var12.p() + var1.random.nextDouble(), 0.0D, 0.0D, 0.0D, new int[0]);
         }

         for(var6 = 0; var6 < this.T().c(); ++var6) {
            for(int var14 = 0; var14 < this.T().b(); ++var14) {
               bei var8 = var3.a(var6, var14, 0);
               var1.update(var8.d(), Blocks.AIR);
            }
         }
      }

   }

   public boolean canPlace(World var1, Location var2) {
      return var1.getData(var2).c().J.isReplacable() && World.a((IBlockAccess)var1, var2.b());
   }

   public IBlockData getPlacedData(World var1, Location var2, EnumFacing var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
      return this.P().a(N, var8.aO().d());
   }

   public IBlockData a(int var1) {
      return this.P().a(N, EnumFacing.b(var1));
   }

   public int c(IBlockData var1) {
      return ((EnumFacing)var1.b(N)).b();
   }

   protected bed e() {
      return new bed(this, new bex[]{N});
   }

   protected bek j() {
      if(this.a == null) {
         this.a = ben.a().a(new String[]{" ", "#", "#"}).a('#', bei.a(beq.a(Blocks.SNOW_BLOCK))).b();
      }

      return this.a;
   }

   protected bek l() {
      if(this.b == null) {
         this.b = ben.a().a(new String[]{"^", "#", "#"}).a('^', bei.a(beq.a(Blocks.PUMPKIN))).a('#', bei.a(beq.a(Blocks.SNOW_BLOCK))).b();
      }

      return this.b;
   }

   protected bek S() {
      if(this.M == null) {
         this.M = ben.a().a(new String[]{"~ ~", "###", "~#~"}).a('#', bei.a(beq.a(Blocks.IRON_BLOCK))).a('~', bei.a(beq.a(Blocks.AIR))).b();
      }

      return this.M;
   }

   protected bek T() {
      if(this.O == null) {
         this.O = ben.a().a(new String[]{"~^~", "###", "~#~"}).a('^', bei.a(beq.a(Blocks.PUMPKIN))).a('#', bei.a(beq.a(Blocks.IRON_BLOCK))).a('~', bei.a(beq.a(Blocks.AIR))).b();
      }

      return this.O;
   }
}
