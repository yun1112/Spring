package game;
/*
name/
currentHealth/maxHealth/


attackPower: strength
evasion: agility/escapable 어떤 것을 의미


goldWorth/
expWorth/
weakness/

1-1   1-2     1-3  1-4
rat  chiken rabbit dog

2-1        2-2   2-3   2-4
monkey sheep  pig  snake

3-1    3-2   3-3    3-4
horse cow tiger dragon*/

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/*    private int baseHealth, currentHealth, maxHealth;//기본, 현재, 최대 체력
    private int baseMana, currentMana, maxMana;//기본, 현재, 최대 마나
    private int baseStrength, currentStrength;//기본, 현재 힘
    private int baseMagic, currentMagic;//기본, 현재 마력
    private int baseAgility, currentAgility;//기본, 현재 민첩성
    private int baseDefense, currentDefense;//기본, 현재 방어력
    private int baseMagicDefense, currentMagicDefense;//기본, 현재 마법 방어력*/

public class Monster extends Entity {
	
    private int goldWorth;//골드
    private int expWorth;//경험치
    private int weakness;//몬스터가 가진 기본 약점
    //1 = physical, 2 = fire, 3 = water, 4 = lightning, 5 = ice, more?!
    private boolean escapable;//탈출(도망) 가능 여부->도망 가능 true/ 도망 불가 false

    public int getGoldWorth(){return goldWorth;}//랜덤 십진수로 곱해지는 statement에서 일반적으로 호출됨 //usually called in a statement multiplied by a random decimal 
    public void setGoldWorth(int g){
        Random rand = new Random();
        int gMin = (int)(g*.7);
        int gMax = (int)(g*1.2);
        goldWorth = rand.nextInt(gMax - gMin +1) + gMin; //generates a number from g*.7 - g*1.2 (70% - 120% of g)
    }

    public int getExpWorth(){return expWorth;}
    public void setExpWorth(int i){expWorth = i;}

    public int getWeakness(){return weakness;}
    public void setWeakness(int i){weakness = i;}

    public boolean isEscapable(){return escapable;}
    public void setEscapable(boolean i){escapable = i;}


    //public Skill[] getSkills(){return blahhh;}
}