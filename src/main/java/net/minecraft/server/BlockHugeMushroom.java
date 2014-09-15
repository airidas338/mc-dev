package net.minecraft.server;
import java.util.Random;

public class BlockHugeMushroom extends Block {

   public static final bev a = bev.a("variant", axa.class);
   private final Block b;


   public BlockHugeMushroom(Material var1, Block var2) {
      super(var1);
      this.j(this.L.b().a(a, axa.l));
      this.b = var2;
   }

   public int a(Random var1) {
      return Math.max(0, var1.nextInt(10) - 7);
   }

   public Item a(IBlockData var1, Random var2, int var3) {
      return Item.a(this.b);
   }

   public IBlockData getPlacedData(World var1, Location var2, EnumFacing var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
      return this.P();
   }

   public IBlockData a(int var1) {
      return this.P().a(a, axa.a(var1));
   }

   public int c(IBlockData var1) {
      return ((axa)var1.b(a)).a();
   }

   protected bed e() {
      return new bed(this, new bex[]{a});
   }

}
