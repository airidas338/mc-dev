package net.minecraft.server;

public abstract class TileEntityLockable extends TileEntity implements vv, vy {

   private InventoryPlayerLock a;


   public TileEntityLockable() {
      this.a = InventoryPlayerLock.a;
   }

   public void a(NBTTagCompound var1) {
      super.a(var1);
      this.a = InventoryPlayerLock.b(var1);
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

   public InventoryPlayerLock i() {
      return this.a;
   }

   public void a(InventoryPlayerLock var1) {
      this.a = var1;
   }

   public IChatBaseComponent getScoreboardDisplayName() {
      return (IChatBaseComponent)(this.k_()?new ChatComponentText(this.getName()):new ChatMessage(this.getName(), new Object[0]));
   }
}
