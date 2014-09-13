package net.minecraft.server;
import java.util.Random;

public class BlockMonsterEggs extends Block {

   public static final bev a = bev.a("variant", axu.class);


   public BlockMonsterEggs() {
      super(Material.CLAY);
      this.j(this.L.b().a(a, axu.a));
      this.c(0.0F);
      this.a(CreativeModeTab.c);
   }

   public int a(Random var1) {
      return 0;
   }

   public static boolean d(IBlock var0) {
      Block var1 = var0.c();
      return var0 == Blocks.STONE.P().a(BlockStone.a, bbb.a) || var1 == Blocks.COBBLESTONE || var1 == Blocks.SMOOTH_BRICK;
   }

   protected ItemStack i(IBlock var1) {
      switch(axt.a[((axu)var1.b(a)).ordinal()]) {
      case 1:
         return new ItemStack(Blocks.COBBLESTONE);
      case 2:
         return new ItemStack(Blocks.SMOOTH_BRICK);
      case 3:
         return new ItemStack(Blocks.SMOOTH_BRICK, 1, bbd.b.a());
      case 4:
         return new ItemStack(Blocks.SMOOTH_BRICK, 1, bbd.c.a());
      case 5:
         return new ItemStack(Blocks.SMOOTH_BRICK, 1, bbd.d.a());
      default:
         return new ItemStack(Blocks.STONE);
      }
   }

   public void a(World var1, Location var2, IBlock var3, float var4, int var5) {
      if(!var1.D && var1.Q().b("doTileDrops")) {
         EntitySilverfish var6 = new EntitySilverfish(var1);
         var6.setPositionRotation((double)var2.n() + 0.5D, (double)var2.o(), (double)var2.p() + 0.5D, 0.0F, 0.0F);
         var1.d((Entity)var6);
         var6.y();
      }

   }

   public int j(World var1, Location var2) {
      IBlock var3 = var1.getData(var2);
      return var3.c().c(var3);
   }

   public IBlock a(int var1) {
      return this.P().a(a, axu.a(var1));
   }

   public int c(IBlock var1) {
      return ((axu)var1.b(a)).a();
   }

   protected bed e() {
      return new bed(this, new bex[]{a});
   }

}
