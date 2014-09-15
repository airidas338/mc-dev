package net.minecraft.server;
import java.util.Random;

public class BlockDaylightDetector extends BlockContainer {

   public static final bew a = bew.a("power", 0, 15);
   private final boolean b;


   public BlockDaylightDetector(boolean var1) {
      super(Material.WOOD);
      this.b = var1;
      this.j(this.L.b().a(a, Integer.valueOf(0)));
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.375F, 1.0F);
      this.a(CreativeModeTab.d);
      this.c(0.2F);
      this.a(f);
      this.c("daylightDetector");
   }

   public void a(IBlockAccess var1, Location var2) {
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.375F, 1.0F);
   }

   public int a(IBlockAccess var1, Location var2, IBlockData var3, EnumFacing var4) {
      return ((Integer)var3.b(a)).intValue();
   }

   public void d(World var1, Location var2) {
      if(!var1.worldProvider.o()) {
         IBlockData var3 = var1.getData(var2);
         int var4 = var1.b(EnumSkyBlock.SKY, var2) - var1.ab();
         float var5 = var1.d(1.0F);
         float var6 = var5 < 3.1415927F?0.0F:6.2831855F;
         var5 += (var6 - var5) * 0.2F;
         var4 = Math.round((float)var4 * MathHelper.cos(var5));
         var4 = MathHelper.a(var4, 0, 15);
         if(this.b) {
            var4 = 15 - var4;
         }

         if(((Integer)var3.b(a)).intValue() != var4) {
            var1.a(var2, var3.a(a, Integer.valueOf(var4)), 3);
         }

      }
   }

   public boolean interact(World var1, Location var2, IBlockData var3, EntityHuman var4, EnumFacing var5, float var6, float var7, float var8) {
      if(var4.cm()) {
         if(var1.isStatic) {
            return true;
         } else {
            if(this.b) {
               var1.a(var2, Blocks.DAYLIGHT_DETECTOR.P().a(a, var3.b(a)), 4);
               Blocks.DAYLIGHT_DETECTOR.d(var1, var2);
            } else {
               var1.a(var2, Blocks.DAYLIGHT_DETECTOR_INVERTED.P().a(a, var3.b(a)), 4);
               Blocks.DAYLIGHT_DETECTOR_INVERTED.d(var1, var2);
            }

            return true;
         }
      } else {
         return super.interact(var1, var2, var3, var4, var5, var6, var7, var8);
      }
   }

   public Item a(IBlockData var1, Random var2, int var3) {
      return Item.a((Block)Blocks.DAYLIGHT_DETECTOR);
   }

   public boolean d() {
      return false;
   }

   public boolean c() {
      return false;
   }

   public int b() {
      return 3;
   }

   public boolean g() {
      return true;
   }

   public TileEntity a(World var1, int var2) {
      return new TileEntityLightDetector();
   }

   public IBlockData a(int var1) {
      return this.P().a(a, Integer.valueOf(var1));
   }

   public int c(IBlockData var1) {
      return ((Integer)var1.b(a)).intValue();
   }

   protected bed e() {
      return new bed(this, new bex[]{a});
   }

}
