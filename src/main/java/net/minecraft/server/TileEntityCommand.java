package net.minecraft.server;

public class TileEntityCommand extends TileEntity {

   private final CommandBlockListenerAbstract a = new TileEntityCommandListener(this);


   public void b(NBTTagCompound var1) {
      super.b(var1);
      this.a.a(var1);
   }

   public void a(NBTTagCompound var1) {
      super.a(var1);
      this.a.b(var1);
   }

   public Packet x_() {
      NBTTagCompound var1 = new NBTTagCompound();
      this.b(var1);
      return new iu(this.c, 2, var1);
   }

   public CommandBlockListenerAbstract getCommandBlock() {
      return this.a;
   }

   public af c() {
      return this.a.n();
   }
}
