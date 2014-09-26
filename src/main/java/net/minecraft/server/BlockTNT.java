package net.minecraft.server;


public class BlockTNT extends Block {

   public static final bet a = bet.a("explode");


   public BlockTNT() {
      super(Material.TNT);
      this.j(this.L.b().a(a, Boolean.valueOf(false)));
      this.a(CreativeModeTab.d);
   }

   public void onPlace(World var1, Location var2, IBlockData var3) {
      super.onPlace(var1, var2, var3);
      if(var1.isBlockIndirectlyPowered(var2)) {
         this.postBreak(var1, var2, var3.a(a, Boolean.valueOf(true)));
         var1.setAir(var2);
      }

   }

   public void doPhysics(World var1, Location var2, IBlockData var3, Block var4) {
      if(var1.isBlockIndirectlyPowered(var2)) {
         this.postBreak(var1, var2, var3.a(a, Boolean.valueOf(true)));
         var1.setAir(var2);
      }

   }

   public void wasExploded(World var1, Location var2, Explosion var3) {
      if(!var1.isStatic) {
         EntityTNTPrimed var4 = new EntityTNTPrimed(var1, (double)((float)var2.n() + 0.5F), (double)((float)var2.o() + 0.5F), (double)((float)var2.p() + 0.5F), var3.c());
         var4.a = var1.random.nextInt(var4.a / 4) + var4.a / 8;
         var1.addEntity((Entity)var4);
      }
   }

   public void postBreak(World var1, Location var2, IBlockData var3) {
      this.a(var1, var2, var3, (EntityLiving)null);
   }

   public void a(World var1, Location var2, IBlockData var3, EntityLiving var4) {
      if(!var1.isStatic) {
         if(((Boolean)var3.b(a)).booleanValue()) {
            EntityTNTPrimed var5 = new EntityTNTPrimed(var1, (double)((float)var2.n() + 0.5F), (double)((float)var2.o() + 0.5F), (double)((float)var2.p() + 0.5F), var4);
            var1.addEntity((Entity)var5);
            var1.makeSound((Entity)var5, "game.tnt.primed", 1.0F, 1.0F);
         }

      }
   }

   public boolean interact(World var1, Location var2, IBlockData var3, EntityHuman var4, EnumFacing var5, float var6, float var7, float var8) {
      if(var4.bY() != null) {
         Item var9 = var4.bY().getItem();
         if(var9 == Items.FLINT_AND_STEEL || var9 == Items.bL) {
            this.a(var1, var2, var3.a(a, Boolean.valueOf(true)), (EntityLiving)var4);
            var1.setAir(var2);
            if(var9 == Items.FLINT_AND_STEEL) {
               var4.bY().damage(1, (EntityLiving)var4);
            } else if(!var4.abilities.canInstantlyBuild) {
               --var4.bY().count;
            }

            return true;
         }
      }

      return super.interact(var1, var2, var3, var4, var5, var6, var7, var8);
   }

   public void a(World var1, Location var2, IBlockData var3, Entity var4) {
      if(!var1.isStatic && var4 instanceof EntityArrow) {
         EntityArrow var5 = (EntityArrow)var4;
         if(var5.au()) {
            this.a(var1, var2, var1.getData(var2).a(a, Boolean.valueOf(true)), var5.c instanceof EntityLiving?(EntityLiving)var5.c:null);
            var1.setAir(var2);
         }
      }

   }

   public boolean a(Explosion var1) {
      return false;
   }

   public IBlockData a(int var1) {
      return this.P().a(a, Boolean.valueOf((var1 & 1) > 0));
   }

   public int c(IBlockData var1) {
      return ((Boolean)var1.b(a)).booleanValue()?1:0;
   }

   protected bed e() {
      return new bed(this, new bex[]{a});
   }

}
