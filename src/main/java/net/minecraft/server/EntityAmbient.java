package net.minecraft.server;


public abstract class EntityAmbient extends EntityInsentient implements wt {

   public EntityAmbient(World var1) {
      super(var1);
   }

   public boolean ca() {
      return false;
   }

   protected boolean a(EntityHuman var1) {
      return false;
   }
}
