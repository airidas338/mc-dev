package net.minecraft.server;

public class TileEntityNote extends TileEntity {

   public byte a;
   public boolean f;


   public void b(NBTTagCompound var1) {
      super.b(var1);
      var1.setByte("note", this.a);
   }

   public void a(NBTTagCompound var1) {
      super.a(var1);
      this.a = var1.getByte("note");
      this.a = (byte)MathHelper.a(this.a, 0, 24);
   }

   public void b() {
      this.a = (byte)((this.a + 1) % 25);
      this.o_();
   }

   public void a(World var1, Location var2) {
      if(var1.getData(var2.a()).c().getMaterial() == Material.AIR) {
         Material var3 = var1.getData(var2.b()).c().getMaterial();
         byte var4 = 0;
         if(var3 == Material.STONE) {
            var4 = 1;
         }

         if(var3 == Material.SAND) {
            var4 = 2;
         }

         if(var3 == Material.SHATTERABLE) {
            var4 = 3;
         }

         if(var3 == Material.WOOD) {
            var4 = 4;
         }

         var1.c(var2, Blocks.NOTE_BLOCK, var4, this.a);
      }
   }
}
