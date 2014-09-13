package net.minecraft.server;

public class BlockSandStone extends Block {

   public static final bev a = bev.a("type", bae.class);


   public BlockSandStone() {
      super(Material.STONE);
      this.j(this.L.b().a(a, bae.a));
      this.a(CreativeModeTab.b);
   }

   public int a(IBlock var1) {
      return ((bae)var1.b(a)).a();
   }

   public IBlock a(int var1) {
      return this.P().a(a, bae.a(var1));
   }

   public int c(IBlock var1) {
      return ((bae)var1.b(a)).a();
   }

   protected bed e() {
      return new bed(this, new bex[]{a});
   }

}
