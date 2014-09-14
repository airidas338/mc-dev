package net.minecraft.server;
import java.util.Iterator;

public class cl extends ab implements y {

   public cl() {
      this.a(new CommandTime());
      this.a(new CommandGamemode());
      this.a(new CommandDifficulty());
      this.a(new bf());
      this.a(new CommandKill());
      this.a(new CommandToggleDownfall());
      this.a(new CommandWeather());
      this.a(new CommandXp());
      this.a(new CommandTp());
      this.a(new CommandGive());
      this.a(new CommandReplaceItem());
      this.a(new CommandStats());
      this.a(new CommandEffect());
      this.a(new CommandEnchant());
      this.a(new CommandParticle());
      this.a(new CommandMe());
      this.a(new CommandSeed());
      this.a(new CommandHelp());
      this.a(new CommandDebug());
      this.a(new CommandTell());
      this.a(new CommandSay());
      this.a(new CommandSpawnPoint());
      this.a(new CommandSetWorldSpawn());
      this.a(new CommandGamerule());
      this.a(new CommandClear());
      this.a(new CommandTestfor());
      this.a(new CommandSpreadplayers());
      this.a(new CommandPlaySound());
      this.a(new CommandScoreboard());
      this.a(new CommandExecute());
      this.a(new CommandTrigger());
      this.a(new CommandAchievement());
      this.a(new CommandSummon());
      this.a(new CommandSetblock());
      this.a(new CommandFill());
      this.a(new CommandClone());
      this.a(new CommandTestforblocks());
      this.a(new CommandBlockdata());
      this.a(new CommandTestforBlock());
      this.a(new CommandTellraw());
      this.a(new CommandWorldborder());
      this.a(new CommandTitle());
      this.a(new CommandEntityData());
      if(MinecraftServer.M().ad()) {
         this.a(new CommandOp());
         this.a(new CommandDeop());
         this.a(new CommandStop());
         this.a(new CommandSaveAll());
         this.a(new CommandSaveOff());
         this.a(new CommandSaveOn());
         this.a(new CommandBanIp());
         this.a(new CommandPardonIp());
         this.a(new CommandBan());
         this.a(new CommandBanlist());
         this.a(new CommandPardon());
         this.a(new CommandKick());
         this.a(new CommandList());
         this.a(new CommandWhitelist());
         this.a(new CommandSetIdleTimeout());
      } else {
         this.a(new CommandPublish());
      }

      CommandAbstract.a((y)this);
   }

   public void a(ICommandSender var1, ICommand var2, int var3, String var4, Object ... var5) {
      boolean var6 = true;
      MinecraftServer var7 = MinecraftServer.M();
      if(!var1.t_()) {
         var6 = false;
      }

      ChatMessage var8 = new ChatMessage("chat.type.admin", new Object[]{var1.d_(), new ChatMessage(var4, var5)});
      var8.b().a(EnumChatFormat.h);
      var8.b().b(Boolean.valueOf(true));
      if(var6) {
         Iterator var9 = var7.an().e.iterator();

         while(var9.hasNext()) {
            EntityHuman var10 = (EntityHuman)var9.next();
            if(var10 != var1 && var7.an().g(var10.cc()) && var2.a(var1)) {
               var10.a((IChatBaseComponent)var8);
            }
         }
      }

      if(var1 != var7 && var7.c[0].Q().b("logAdminCommands")) {
         var7.a((IChatBaseComponent)var8);
      }

      boolean var11 = var7.c[0].Q().b("sendCommandFeedback");
      if(var1 instanceof aqf) {
         var11 = ((aqf)var1).m();
      }

      if((var3 & 1) != 1 && var11) {
         var1.a(new ChatMessage(var4, var5));
      }

   }
}
