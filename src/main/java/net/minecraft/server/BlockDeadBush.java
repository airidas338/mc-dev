package net.minecraft.server;
import java.util.Random;

public class BlockDeadBush extends BlockPlant {

   protected BlockDeadBush() {
      super(Material.REPLACAEBLE_PLAN);
      float var1 = 0.4F;
      this.a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, 0.8F, 0.5F + var1);
   }

   protected boolean c(Block var1) {
      return var1 == Blocks.m || var1 == Blocks.cz || var1 == Blocks.cu || var1 == Blocks.d;
   }

   public boolean f(World var1, Location var2) {
      return true;
   }

   public Item a(IBlock var1, Random var2, int var3) {
      return null;
   }

   public void a(World var1, EntityHuman var2, Location var3, IBlock var4, TileEntity var5) {
      if(!var1.D && var2.bY() != null && var2.bY().b() == Items.be) {
         var2.b(ty.H[Block.a((Block)this)]);
         a(var1, var3, new ItemStack(Blocks.I, 1, 0));
      } else {
         super.a(var1, var2, var3, var4, var5);
      }

   }
}
