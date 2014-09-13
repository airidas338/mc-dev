package net.minecraft.server;

public abstract class bdf extends TileEntity implements vv, vy {

   private vx a;


   public bdf() {
      this.a = vx.a;
   }

   public void a(NBTTagCompound var1) {
      super.a(var1);
      this.a = vx.b(var1);
   }

   public void b(NBTTagCompound var1) {
      super.b(var1);
      if(this.a != null) {
         this.a.a(var1);
      }

   }

   public boolean q_() {
      return this.a != null && !this.a.a();
   }

   public vx i() {
      return this.a;
   }

   public void a(vx var1) {
      this.a = var1;
   }

   public IChatBaseComponent e_() {
      return (IChatBaseComponent)(this.k_()?new ChatComponentText(this.d_()):new ChatMessage(this.d_(), new Object[0]));
   }
}
