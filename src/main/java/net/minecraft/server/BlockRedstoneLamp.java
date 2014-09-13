package net.minecraft.server;
import java.util.Random;

public class BlockRedstoneLamp extends Block {

   private final boolean a;


   public BlockRedstoneLamp(boolean var1) {
      super(Material.BUILDABLE_GLASS);
      this.a = var1;
      if(var1) {
         this.a(1.0F);
      }

   }

   public void c(World var1, Location var2, IBlock var3) {
      if(!var1.D) {
         if(this.a && !var1.z(var2)) {
            var1.a(var2, aty.bJ.P(), 2);
         } else if(!this.a && var1.z(var2)) {
            var1.a(var2, aty.bK.P(), 2);
         }

      }
   }

   public void a(World var1, Location var2, IBlock var3, Block var4) {
      if(!var1.D) {
         if(this.a && !var1.z(var2)) {
            var1.a(var2, (Block)this, 4);
         } else if(!this.a && var1.z(var2)) {
            var1.a(var2, aty.bK.P(), 2);
         }

      }
   }

   public void b(World var1, Location var2, IBlock var3, Random var4) {
      if(!var1.D) {
         if(this.a && !var1.z(var2)) {
            var1.a(var2, aty.bJ.P(), 2);
         }

      }
   }

   public Item a(IBlock var1, Random var2, int var3) {
      return Item.a(aty.bJ);
   }

   protected amj i(IBlock var1) {
      return new amj(aty.bJ);
   }
}
