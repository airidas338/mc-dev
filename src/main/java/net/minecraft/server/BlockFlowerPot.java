package net.minecraft.server;
import java.util.Random;

public class BlockFlowerPot extends BlockContainer {

   public static final bew a = bew.a("legacy_data", 0, 15);
   public static final bev b = bev.a("contents", awf.class);


   public BlockFlowerPot() {
      super(Material.ORIENTABLE);
      this.j(this.L.b().a(b, awf.a).a(a, Integer.valueOf(0)));
      this.h();
   }

   public void h() {
      float var1 = 0.375F;
      float var2 = var1 / 2.0F;
      this.a(0.5F - var2, 0.0F, 0.5F - var2, 0.5F + var2, var1, 0.5F + var2);
   }

   public boolean c() {
      return false;
   }

   public int b() {
      return 3;
   }

   public boolean d() {
      return false;
   }

   public boolean interact(World var1, Location var2, IBlockData var3, EntityHuman var4, EnumFacing var5, float var6, float var7, float var8) {
      ItemStack var9 = var4.bg.h();
      if(var9 != null && var9.getItem() instanceof ItemBlock) {
         TileEntityFlowerPot var10 = this.d(var1, var2);
         if(var10 == null) {
            return false;
         } else if(var10.b() != null) {
            return false;
         } else {
            Block var11 = Block.a(var9.getItem());
            if(!this.a(var11, var9.getData())) {
               return false;
            } else {
               var10.a(var9.getItem(), var9.getData());
               var10.o_();
               var1.notify(var2);
               if(!var4.abilities.canInstantlyBuild && --var9.count <= 0) {
                  var4.bg.a(var4.bg.c, (ItemStack)null);
               }

               return true;
            }
         }
      } else {
         return false;
      }
   }

   private boolean a(Block var1, int var2) {
      return var1 != Blocks.YELLOW_FLOWER && var1 != Blocks.RED_ROSE && var1 != Blocks.CACTUS && var1 != Blocks.BROWN_MUSHROOM && var1 != Blocks.RED_MUSHROOM && var1 != Blocks.SAPLING && var1 != Blocks.DEAD_BUSH?var1 == Blocks.LONG_GRASS && var2 == EnumFoliage.c.a():true;
   }

   public int j(World var1, Location var2) {
      TileEntityFlowerPot var3 = this.d(var1, var2);
      return var3 != null && var3.b() != null?var3.c():0;
   }

   public boolean canPlace(World var1, Location var2) {
      return super.canPlace(var1, var2) && World.a((IBlockAccess)var1, var2.b());
   }

   public void doPhysics(World var1, Location var2, IBlockData var3, Block var4) {
      if(!World.a((IBlockAccess)var1, var2.b())) {
         this.b(var1, var2, var3, 0);
         var1.setAir(var2);
      }

   }

   public void remove(World var1, Location var2, IBlockData var3) {
      TileEntityFlowerPot var4 = this.d(var1, var2);
      if(var4 != null && var4.b() != null) {
         a(var1, var2, new ItemStack(var4.b(), 1, var4.c()));
      }

      super.remove(var1, var2, var3);
   }

   public void a(World var1, Location var2, IBlockData var3, EntityHuman var4) {
      super.a(var1, var2, var3, var4);
      if(var4.abilities.canInstantlyBuild) {
         TileEntityFlowerPot var5 = this.d(var1, var2);
         if(var5 != null) {
            var5.a((Item)null, 0);
         }
      }

   }

   public Item a(IBlockData var1, Random var2, int var3) {
      return Items.bQ;
   }

   private TileEntityFlowerPot d(World var1, Location var2) {
      TileEntity var3 = var1.getTileEntity(var2);
      return var3 instanceof TileEntityFlowerPot?(TileEntityFlowerPot)var3:null;
   }

   public TileEntity a(World var1, int var2) {
      Object var3 = null;
      int var4 = 0;
      switch(var2) {
      case 1:
         var3 = Blocks.RED_ROSE;
         var4 = EnumFlowerType.b.b();
         break;
      case 2:
         var3 = Blocks.YELLOW_FLOWER;
         break;
      case 3:
         var3 = Blocks.SAPLING;
         var4 = ayx.a.a();
         break;
      case 4:
         var3 = Blocks.SAPLING;
         var4 = ayx.b.a();
         break;
      case 5:
         var3 = Blocks.SAPLING;
         var4 = ayx.c.a();
         break;
      case 6:
         var3 = Blocks.SAPLING;
         var4 = ayx.d.a();
         break;
      case 7:
         var3 = Blocks.RED_MUSHROOM;
         break;
      case 8:
         var3 = Blocks.BROWN_MUSHROOM;
         break;
      case 9:
         var3 = Blocks.CACTUS;
         break;
      case 10:
         var3 = Blocks.DEAD_BUSH;
         break;
      case 11:
         var3 = Blocks.LONG_GRASS;
         var4 = EnumFoliage.c.a();
         break;
      case 12:
         var3 = Blocks.SAPLING;
         var4 = ayx.e.a();
         break;
      case 13:
         var3 = Blocks.SAPLING;
         var4 = ayx.f.a();
      }

      return new TileEntityFlowerPot(Item.getItemOf((Block)var3), var4);
   }

   protected bed e() {
      return new bed(this, new bex[]{b, a});
   }

   public int c(IBlockData var1) {
      return ((Integer)var1.b(a)).intValue();
   }

   public IBlockData a(IBlockData var1, IBlockAccess var2, Location var3) {
      awf var4 = awf.a;
      TileEntity var5 = var2.getTileEntity(var3);
      if(var5 instanceof TileEntityFlowerPot) {
         TileEntityFlowerPot var6 = (TileEntityFlowerPot)var5;
         Item var7 = var6.b();
         if(var7 instanceof ItemBlock) {
            int var8 = var6.c();
            Block var9 = Block.a(var7);
            if(var9 == Blocks.SAPLING) {
               switch(awe.a[ayx.a(var8).ordinal()]) {
               case 1:
                  var4 = awf.l;
                  break;
               case 2:
                  var4 = awf.m;
                  break;
               case 3:
                  var4 = awf.n;
                  break;
               case 4:
                  var4 = awf.o;
                  break;
               case 5:
                  var4 = awf.p;
                  break;
               case 6:
                  var4 = awf.q;
                  break;
               default:
                  var4 = awf.a;
               }
            } else if(var9 == Blocks.LONG_GRASS) {
               switch(var8) {
               case 0:
                  var4 = awf.t;
                  break;
               case 2:
                  var4 = awf.u;
                  break;
               default:
                  var4 = awf.a;
               }
            } else if(var9 == Blocks.YELLOW_FLOWER) {
               var4 = awf.k;
            } else if(var9 == Blocks.RED_ROSE) {
               switch(awe.b[EnumFlowerType.a(awc.b, var8).ordinal()]) {
               case 1:
                  var4 = awf.b;
                  break;
               case 2:
                  var4 = awf.c;
                  break;
               case 3:
                  var4 = awf.d;
                  break;
               case 4:
                  var4 = awf.e;
                  break;
               case 5:
                  var4 = awf.f;
                  break;
               case 6:
                  var4 = awf.g;
                  break;
               case 7:
                  var4 = awf.h;
                  break;
               case 8:
                  var4 = awf.i;
                  break;
               case 9:
                  var4 = awf.j;
                  break;
               default:
                  var4 = awf.a;
               }
            } else if(var9 == Blocks.RED_MUSHROOM) {
               var4 = awf.r;
            } else if(var9 == Blocks.BROWN_MUSHROOM) {
               var4 = awf.s;
            } else if(var9 == Blocks.DEAD_BUSH) {
               var4 = awf.t;
            } else if(var9 == Blocks.CACTUS) {
               var4 = awf.v;
            }
         }
      }

      return var1.a(b, var4);
   }

}
