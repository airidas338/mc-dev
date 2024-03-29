package net.minecraft.server;

public class FoodMetaData {

   private int foodLevel = 20;
   private float saturationLevel = 5.0F;
   private float exhaustionLevel;
   private int foodTickTimer;
   private int e = 20;


   public void eat(int var1, float var2) {
      this.foodLevel = Math.min(var1 + this.foodLevel, 20);
      this.saturationLevel = Math.min(this.saturationLevel + (float)var1 * var2 * 2.0F, (float)this.foodLevel);
   }

   public void a(ItemFood var1, ItemStack var2) {
      this.eat(var1.h(var2), var1.i(var2));
   }

   public void a(EntityHuman var1) {
      EnumDifficulty var2 = var1.o.aa();
      this.e = this.foodLevel;
      if(this.exhaustionLevel > 4.0F) {
         this.exhaustionLevel -= 4.0F;
         if(this.saturationLevel > 0.0F) {
            this.saturationLevel = Math.max(this.saturationLevel - 1.0F, 0.0F);
         } else if(var2 != EnumDifficulty.PEACEFUL) {
            this.foodLevel = Math.max(this.foodLevel - 1, 0);
         }
      }

      if(var1.o.getGameRules().getBoolean("naturalRegeneration") && this.foodLevel >= 18 && var1.cl()) {
         ++this.foodTickTimer;
         if(this.foodTickTimer >= 80) {
            var1.g(1.0F);
            this.a(3.0F);
            this.foodTickTimer = 0;
         }
      } else if(this.foodLevel <= 0) {
         ++this.foodTickTimer;
         if(this.foodTickTimer >= 80) {
            if(var1.bm() > 10.0F || var2 == EnumDifficulty.HARD || var1.bm() > 1.0F && var2 == EnumDifficulty.NORMAL) {
               var1.a(DamageSource.STARVE, 1.0F);
            }

            this.foodTickTimer = 0;
         }
      } else {
         this.foodTickTimer = 0;
      }

   }

   public void a(NBTTagCompound var1) {
      if(var1.hasKeyOfType("foodLevel", 99)) {
         this.foodLevel = var1.getInt("foodLevel");
         this.foodTickTimer = var1.getInt("foodTickTimer");
         this.saturationLevel = var1.getFloat("foodSaturationLevel");
         this.exhaustionLevel = var1.getFloat("foodExhaustionLevel");
      }

   }

   public void b(NBTTagCompound var1) {
      var1.setInt("foodLevel", this.foodLevel);
      var1.setInt("foodTickTimer", this.foodTickTimer);
      var1.setFloat("foodSaturationLevel", this.saturationLevel);
      var1.setFloat("foodExhaustionLevel", this.exhaustionLevel);
   }

   public int getFoodLevel() {
      return this.foodLevel;
   }

   public boolean c() {
      return this.foodLevel < 20;
   }

   public void a(float var1) {
      this.exhaustionLevel = Math.min(this.exhaustionLevel + var1, 40.0F);
   }

   public float getSaturationLevel() {
      return this.saturationLevel;
   }

   public void a(int var1) {
      this.foodLevel = var1;
   }
}
