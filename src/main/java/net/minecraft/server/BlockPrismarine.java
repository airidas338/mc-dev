package net.minecraft.server;

public class BlockPrismarine extends Block {

   public static final bev a = bev.a("variant", azj.class);
   public static final int b = azj.a.a();
   public static final int M = azj.b.a();
   public static final int N = azj.c.a();


   public BlockPrismarine() {
      super(Material.STONE);
      this.j(this.L.b().a(a, azj.a));
      this.a(CreativeModeTab.b);
   }

   public int a(IBlockData var1) {
      return ((azj)var1.b(a)).a();
   }

   public int c(IBlockData var1) {
      return ((azj)var1.b(a)).a();
   }

   protected bed e() {
      return new bed(this, new bex[]{a});
   }

   public IBlockData a(int var1) {
      return this.P().a(a, azj.a(var1));
   }

}
