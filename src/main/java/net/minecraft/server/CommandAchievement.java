package net.minecraft.server;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CommandAchievement extends CommandAbstract {

   public String getCommand() {
      return "achievement";
   }

   public int a() {
      return 2;
   }

   public String c(ICommandListener var1) {
      return "commands.achievement.usage";
   }

   public void execute(ICommandListener var1, String[] var2) throws CommandException {
      if(var2.length < 2) {
         throw new ExceptionUsage("commands.achievement.usage", new Object[0]);
      } else {
         Statistic var3 = StatisticList.a(var2[1]);
         if(var3 == null && !var2[1].equals("*")) {
            throw new CommandException("commands.achievement.unknownAchievement", new Object[]{var2[1]});
         } else {
            EntityPlayer var4 = var2.length >= 3?a(var1, var2[2]):b(var1);
            boolean var5 = var2[0].equalsIgnoreCase("give");
            boolean var6 = var2[0].equalsIgnoreCase("take");
            if(var5 || var6) {
               if(var3 == null) {
                  Iterator var11;
                  Achievement var12;
                  if(var5) {
                     var11 = AchievementList.e.iterator();

                     while(var11.hasNext()) {
                        var12 = (Achievement)var11.next();
                        var4.b((Statistic)var12);
                     }

                     a(var1, this, "commands.achievement.give.success.all", new Object[]{var4.getName()});
                  } else if(var6) {
                     var11 = Lists.reverse(AchievementList.e).iterator();

                     while(var11.hasNext()) {
                        var12 = (Achievement)var11.next();
                        var4.a((Statistic)var12);
                     }

                     a(var1, this, "commands.achievement.take.success.all", new Object[]{var4.getName()});
                  }

               } else {
                  if(var3 instanceof Achievement) {
                     Achievement var7 = (Achievement)var3;
                     ArrayList var8;
                     Iterator var9;
                     Achievement var10;
                     if(var5) {
                        if(var4.A().a(var7)) {
                           throw new CommandException("commands.achievement.alreadyHave", new Object[]{var4.getName(), var3.j()});
                        }

                        for(var8 = Lists.newArrayList(); var7.c != null && !var4.A().a(var7.c); var7 = var7.c) {
                           var8.add(var7.c);
                        }

                        var9 = Lists.reverse(var8).iterator();

                        while(var9.hasNext()) {
                           var10 = (Achievement)var9.next();
                           var4.b((Statistic)var10);
                        }
                     } else if(var6) {
                        if(!var4.A().a(var7)) {
                           throw new CommandException("commands.achievement.dontHave", new Object[]{var4.getName(), var3.j()});
                        }

                        for(var8 = Lists.newArrayList(Iterators.filter(AchievementList.e.iterator(), new av(this, var4, var3))); var7.c != null && var4.A().a(var7.c); var7 = var7.c) {
                           var8.remove(var7.c);
                        }

                        var9 = var8.iterator();

                        while(var9.hasNext()) {
                           var10 = (Achievement)var9.next();
                           var4.a((Statistic)var10);
                        }
                     }
                  }

                  if(var5) {
                     var4.b(var3);
                     a(var1, this, "commands.achievement.give.success.one", new Object[]{var4.getName(), var3.j()});
                  } else if(var6) {
                     var4.a(var3);
                     a(var1, this, "commands.achievement.take.success.one", new Object[]{var3.j(), var4.getName()});
                  }

               }
            }
         }
      }
   }

   public List tabComplete(ICommandListener var1, String[] var2, Location var3) {
      if(var2.length == 1) {
         return a(var2, new String[]{"give", "take"});
      } else if(var2.length != 2) {
         return var2.length == 3?a(var2, MinecraftServer.M().I()):null;
      } else {
         ArrayList var4 = Lists.newArrayList();
         Iterator var5 = StatisticList.stats.iterator();

         while(var5.hasNext()) {
            Statistic var6 = (Statistic)var5.next();
            var4.add(var6.name);
         }

         return a(var2, var4);
      }
   }

   public boolean isListStart(String[] var1, int var2) {
      return var2 == 2;
   }
}
