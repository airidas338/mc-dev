package net.minecraft.server;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ItemPotion extends Item {

   private Map a = Maps.newHashMap();
   private static final Map b = Maps.newLinkedHashMap();


   public ItemPotion() {
      this.c(1);
      this.a(true);
      this.d(0);
      this.a(CreativeModeTab.k);
   }

   public List h(ItemStack var1) {
      if(var1.hasTag() && var1.getTag().hasKeyOfType("CustomPotionEffects", 9)) {
         ArrayList var7 = Lists.newArrayList();
         NBTTagList var3 = var1.getTag().getList("CustomPotionEffects", 10);

         for(int var4 = 0; var4 < var3.size(); ++var4) {
            NBTTagCompound var5 = var3.get(var4);
            MobEffect var6 = MobEffect.b(var5);
            if(var6 != null) {
               var7.add(var6);
            }
         }

         return var7;
      } else {
         List var2 = (List)this.a.get(Integer.valueOf(var1.getData()));
         if(var2 == null) {
            var2 = PotionBrewer.getEffects(var1.getData(), false);
            this.a.put(Integer.valueOf(var1.getData()), var2);
         }

         return var2;
      }
   }

   public List e(int var1) {
      List var2 = (List)this.a.get(Integer.valueOf(var1));
      if(var2 == null) {
         var2 = PotionBrewer.getEffects(var1, false);
         this.a.put(Integer.valueOf(var1), var2);
      }

      return var2;
   }

   public ItemStack b(ItemStack var1, World var2, EntityHuman var3) {
      if(!var3.abilities.canInstantlyBuild) {
         --var1.count;
      }

      if(!var2.isStatic) {
         List var4 = this.h(var1);
         if(var4 != null) {
            Iterator var5 = var4.iterator();

            while(var5.hasNext()) {
               MobEffect var6 = (MobEffect)var5.next();
               var3.c(new MobEffect(var6));
            }
         }
      }

      var3.b(StatisticList.USE_ITEM_COUNT[Item.getId((Item)this)]);
      if(!var3.abilities.canInstantlyBuild) {
         if(var1.count <= 0) {
            return new ItemStack(Items.bA);
         }

         var3.bg.a(new ItemStack(Items.bA));
      }

      return var1;
   }

   public int d(ItemStack var1) {
      return 32;
   }

   public EnumAnimation e(ItemStack var1) {
      return EnumAnimation.DRINK;
   }

   public ItemStack a(ItemStack var1, World var2, EntityHuman var3) {
      if(f(var1.getData())) {
         if(!var3.abilities.canInstantlyBuild) {
            --var1.count;
         }

         var2.makeSound((Entity)var3, "random.bow", 0.5F, 0.4F / (g.nextFloat() * 0.4F + 0.8F));
         if(!var2.isStatic) {
            var2.addEntity((Entity)(new EntityPotion(var2, var3, var1)));
         }

         var3.b(StatisticList.USE_ITEM_COUNT[Item.getId((Item)this)]);
         return var1;
      } else {
         var3.a(var1, this.d(var1));
         return var1;
      }
   }

   public static boolean f(int var0) {
      return (var0 & 16384) != 0;
   }

   public String a(ItemStack var1) {
      if(var1.getData() == 0) {
         return LocaleI18n.get("item.emptyPotion.name").trim();
      } else {
         String var2 = "";
         if(f(var1.getData())) {
            var2 = LocaleI18n.get("potion.prefix.grenade").trim() + " ";
         }

         List var3 = Items.POTION.h(var1);
         String var4;
         if(var3 != null && !var3.isEmpty()) {
            var4 = ((MobEffect)var3.get(0)).g();
            var4 = var4 + ".postfix";
            return var2 + LocaleI18n.get(var4).trim();
         } else {
            var4 = PotionBrewer.c(var1.getData());
            return LocaleI18n.get(var4).trim() + " " + super.a(var1);
         }
      }
   }

}
