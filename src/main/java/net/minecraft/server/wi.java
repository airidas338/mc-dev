package net.minecraft.server;


public class wi extends DamageSource {

   protected Entity q;
   private boolean r = false;


   public wi(String var1, Entity var2) {
      super(var1);
      this.q = var2;
   }

   public wi v() {
      this.r = true;
      return this;
   }

   public boolean w() {
      return this.r;
   }

   public Entity getEntity() {
      return this.q;
   }

   public IChatBaseComponent b(EntityLiving var1) {
      ItemStack var2 = this.q instanceof EntityLiving?((EntityLiving)this.q).bz():null;
      String var3 = "death.attack." + this.p;
      String var4 = var3 + ".item";
      return var2 != null && var2.s() && fi.c(var4)?new ChatMessage(var4, new Object[]{var1.getScoreboardDisplayName(), this.q.getScoreboardDisplayName(), var2.C()}):new ChatMessage(var3, new Object[]{var1.getScoreboardDisplayName(), this.q.getScoreboardDisplayName()});
   }

   public boolean r() {
      return this.q != null && this.q instanceof EntityLiving && !(this.q instanceof EntityHuman);
   }
}
