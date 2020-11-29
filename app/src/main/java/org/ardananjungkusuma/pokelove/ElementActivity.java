package org.ardananjungkusuma.pokelove;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import org.ardananjungkusuma.pokelove.models.Ball;
import org.ardananjungkusuma.pokelove.models.Element;
import org.ardananjungkusuma.pokelove.models.ElementAdapter;

import java.util.ArrayList;
import java.util.List;

public class ElementActivity extends AppCompatActivity implements ElementAdapter.OnElementClickListener {

    public static final String Key_ElementActivity = "Key_ElementActivity";

    private RecyclerView rv;
    private ElementAdapter elementAdapter;
    public RecyclerView.LayoutManager layoutManager;
    public List<Element> listElement = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_element);
        rv = (RecyclerView) findViewById(R.id.rvElement);
        listElement.add(new Element(
           "Normal","The Normal type (Japanese: ノーマルタイプ Normal type) is one of the eighteen types. Prior to changes in Generation IV, all damaging Normal-type moves were physical, but they may now also be special, depending on the move.","The Normal type is tied with the Electric type for the fewest defensive weaknesses, but with no resistances and one immunity, it is also tied with Ice as the least resistant type. Many Normal-type Pokémon with a secondary type mitigate their weakness with the secondary type (as with Flying, the type most commonly paired with Normal), leaving them with only the weaknesses of their secondary type.\n" +
                "\n" +
                "Normal-type Pokémon, on average, have the lowest Defense and Special Defense of all Pokémon and of fully evolved Pokémon.","The Normal type is the only type that is not super effective against any other type.\n" +
                "\n" +
                "The combination of Normal and Ground-type moves provides good neutral coverage, with only five type combinations resisting both, because Ground covers both of the types that resist Normal. Their inability to hit Ghost-type Pokémon can be nullified by using Foresight, Odor Sleuth, or by Pokémon with the Ability Scrappy. In these cases, it will provide unresisted coverage when paired with Fighting-type moves (excluding Pokémon with Wonder Guard).\n" +
                "\n" +
                "On average, fully evolved Pokémon with the Normal type have the lowest base Special Attack of all types.","When used in contests, Normal-type moves do not favor a particular contest condition. However, the Normal type has the most moves that can jam.","https://cdn.bulbagarden.net/upload/2/22/GO_Normal.png"
        ));
        listElement.add(new Element(
                "Fighting","The Fighting type (Japanese: かくとうタイプ Fighting type) is one of the eighteen types. Prior to changes in Generation IV, all damaging Fighting-type moves were physical, but they may now also be special depending on the attack.","While the Fighting type has three different weaknesses, Fighting-type Pokémon with a secondary Steel typing have the advantage of having those three weaknesses neutralized, leaving them only with Steel's weaknesses. Fighting-type Pokémon with a secondary Dark typing have their Psychic weakness completely immunized.","The Fighting type hits five different types for super-effective damage, the most for any type, tied by only the Ground type. It is the only type that deals super effective damage against Normal. Ghost's immunity to Fighting can be nullified by Foresight or Odor Sleuth.\n" +
                "\n" +
                "Most Fighting-type Pokémon can learn Rock-type moves to check Bug-types and Flying-types. Additionally, many Fighting types can also learn Poison type moves to deal with Fairy types, as well as Dark and sometimes Ghost type moves to deal with Psychic-types. Notably, the combination of Fighting and Ghost deals at least neutral damage to all type combinations bar Normal/Ghost, which has not materialized (unless Trick-or-Treat is considered).\n" +
                "\n" +
                "On average, Fighting-type Pokémon have the highest physical Attack of all types.","In Contests, Fighting-type moves are typically Cool or Tough moves. None of them are considered Cute.","https://cdn.bulbagarden.net/upload/1/1e/GO_Fighting.png"
        ));
        listElement.add(new Element(
                "Flying","The Flying type (Japanese: ひこうタイプ Flying type) is one of the eighteen types. Prior to changes in Generation IV, all damaging Flying-type moves were physical, but they may now also be special depending on the attack.","In addition to being immune to Ground-type attacks and Arena Trap, Flying-type Pokémon are unaffected by Rototiller and all entry hazards (except Stealth Rock). Flying-type Pokémon also cannot absorb Toxic Spikes simply by switching in and do not receive the benefits from terrains (though they can still use Seeds). These immunities, as well as the immunity to Arena Trap, are removed when a Flying-type Pokémon is grounded by Ingrain, Gravity, Smack Down, Thousand Arrows, or Iron Ball. Sky Drop can pick up a Flying-type target and make it unable to move. On the next turn, Sky Drop will fail and free the target, even if the target is grounded.\n" +
                "\n" +
                "When a Flying-type uses Roost, it temporarily loses its Flying type for a turn. If a pure Flying-type Pokémon uses Roost, then it will become a ??? type in Generation IV and a Normal type in Generation V onward.\n" +
                "\n" +
                "Flying-type Pokémon, on average, have the highest Speed of all Pokémon and of fully-evolved Pokémon.","Flying-type attacks are very powerful combined with some other attacking types, most notably Ground. Ground is strong against every type that resists Flying, and vice versa, so this combination is resisted only by Flying-type Pokémon whose other type resists Flying (such as an Electric Flying Pokémon).\n" +
                "\n" +
                "The effectiveness of the move Flying Press is calculated by multiplying the effectiveness of its move type (usually Fighting) and the Flying type.","In Contests, Flying-type moves are typically Cool moves.","https://cdn.bulbagarden.net/upload/8/87/GO_Flying.png"
        ));
        listElement.add(new Element(
                "Poison","The Poison type (Japanese: どくタイプ Poison type) is one of the eighteen types. Prior to changes in Generation IV, all damaging Poison-type moves were physical, but they may now also be special depending on the attack.","Poison-type Pokémon are immune to being poisoned (except by a Pokémon with Corrosion), and a grounded Poison-type Pokémon automatically removes Toxic Spikes on its side when it switches in. Although the majority of non-Poison types are able to learn Toxic, as of Generation VI, when a Poison-type uses the move, it cannot miss, bypassing accuracy checks and semi-invulnerable turns from moves such as Fly and Dig.","Poison-type moves, including the damaging moves, usually are capable of inflicting poison or bad poison. Poison-type attacks pair well with Ground, which covers Rock, Poison, and Steel-type Pokémon while Poison covers Grass.","In Contests, Poison-type moves typically become Clever or Tough moves. None of them are considered Cute.","https://cdn.bulbagarden.net/upload/f/ff/GO_Poison.png"
        ));
        listElement.add(new Element(
                "Ground","The Ground type (Japanese: じめんタイプ Ground type) is one of the eighteen types. Prior to changes in Generation IV, all damaging Ground-type moves were physical, but they may now also be special depending on the attack.","Ground-type Pokémon are not damaged by sandstorms, and are immune to Electric attacks. Despite their immunity, they can still become paralyzed.","Ground is the only type super effective against Electric, and is super effective against five types in total, tying with Fighting for the most super effective matchups.\n" +
                "\n" +
                "Because Ground is so useful offensively and resisted by so few types, Ground often provides good coverage when combined with another type of attack. It does particularly well when combined with Ice, as Ice's strong matchups include Grass and Flying.\n" +
                "\n" +
                "Ground attacks cannot hit Pokémon under the effect of Magnet Rise or Telekinesis, though all Pokémon lose their immunity to Ground when they are grounded (such as by Ingrain, Gravity, or Thousand Arrows). Further, most Ground-type Pokémon can learn Rock-type moves (mainly those available via TM such as Rock Slide) to check Flying-types, along with Bug-types and Ice-types.","In Contests, Ground-type moves are typically Tough moves.","https://cdn.bulbagarden.net/upload/2/21/GO_Ground.png"
        ));
        listElement.add(new Element(
                "Rock","The Rock type (Japanese: いわタイプ Rock type) is one of the eighteen types. Prior to changes in Generation IV, all damaging Rock-type moves were physical, but they may now also be special depending on the attack.","Tied with Grass, Rock types have the most weaknesses of any type, with five. Additionally, double weaknesses among Rock types are very common.\n" +
                "\n" +
                "Since Generation IV, the Special Defense of a Rock-type Pokémon is increased by 50% during a sandstorm, in addition to being immune to the damage caused by it.\n" +
                "\n" +
                "Rock-type Pokémon, on average, have the lowest Speed of all Pokémon and of fully evolved Pokémon.","In particular, Rock pairs well with Ground, since very few Pokémon naturally resist this combination. Most Rock-types can learn Earthquake to this end. The biggest drawback of Rock-type moves is the large percentage of moves which have less than 100% accuracy.","In Contests, Rock-type moves are typically Tough moves.","https://cdn.bulbagarden.net/upload/1/11/GO_Rock.png"
        ));
        listElement.add(new Element(
                "Bug","The Bug type (Japanese: むしタイプ Bug type) is one of the eighteen types. Prior to changes in Generation IV, all damaging Bug-type moves were physical, but they may now also be special depending on the attack.","On average, Bug Pokémon have the lowest base HP and base stat total of all types.","Bug is tied with Grass as the most resisted type, with seven types resisting each of them. These resistant types are most effectively covered by Water-type attacks.\n" +
                "\n" +
                "On average, Bug Pokémon have the lowest base Special Attack of all types.","In Contests, Bug-type moves do not favor any one Contest category.","https://cdn.bulbagarden.net/upload/9/94/GO_Bug.png"
        ));
        listElement.add(new Element(
                "Ghost","The Ghost type (Japanese: ゴーストタイプ Ghost type) is one of the eighteen types. Prior to changes in Generation IV, all damaging Ghost-type moves were physical, but they may now also be special depending on the attack.","Ghost is the only type with more than one immunity. However, these immunities can be removed by Foresight, Odor Sleuth, or Scrappy. As of Generation VI, Ghost-type Pokémon are immune to being trapped by all trapping moves and Abilities, including the binding effect of moves such as Infestation. Ghost types are also guaranteed to run from wild battles regardless of Speed. Most Ghost-type Pokémon can learn Will-O-Wisp and other status condition-inducing moves.\n" +
                "\n" +
                "Ghost types are also unique in the fact that they have a type-specific attack: Curse, which works differently for Ghost-type Pokémon than it does for other Pokémon. The move Trick-or-Treat adds the Ghost type to the target's types.","Since Steel-type Pokémon no longer resist Ghost-type attacks in Generation VI, Ghost is tied with Dragon for the least resisted type, being resisted by Dark and ineffective against Normal. Consequently, no Pokémon currently resists a combination of Fighting and Ghost-type attacks, as the only type combination capable of this (Normal/Ghost) has never materialized (except when Trick-or-Treat is considered).","In Contests, Ghost-type moves are typically Clever moves, but some may be any of the other Contest conditions.","https://cdn.bulbagarden.net/upload/a/a1/GO_Ghost.png"
        ));
        listElement.add(new Element(
                "Steel","The Steel type (Japanese: はがねタイプ Steel type) is one of the eighteen types. Prior to changes in Generation IV, all damaging Steel-type moves were physical, but they may now also be special depending on the attack.\n" +
                "\n" +
                "The Steel type was introduced in Generation II, along with the Dark type.","In Generation II, the Steel type was created to balance out the previously overpowered Normal and Psychic types, as both types are resisted by Steel. Although the number of Steel's resistances decreased from 11 to 10 in Generation VI, Steel remains the most resistant type. Steel types also cannot be poisoned (except by Twineedle in Generation II or if poisoned by a Pokémon with Corrosion) or damaged by a sandstorm.\n" +
                "\n" +
                "Normal/Steel, Electric/Steel, and Ghost/Steel are tied for the most resistances, having 12 resistances each, although there are currently no Pokémon with the combination of Normal/Steel.\n" +
                "\n" +
                "Steel-type Pokémon, on average, have the highest physical Defense among all Pokémon and among fully evolved Pokémon.","While some Pokémon resist Steel-type attacks, many of these Pokémon are weak to Ground, so combinations of Steel and Ground attacks tend to work well.","In Contests, Steel-type moves are typically Cool moves.","https://cdn.bulbagarden.net/upload/d/d2/GO_Steel.png"
        ));
        listElement.add(new Element(
                "Fire","The Fire type (Japanese: ほのおタイプ Flame type) is one of the eighteen types. Prior to changes in Generation IV, all damaging Fire-type moves were special, but they may now also be physical depending on the attack.","Very few Fire-type Pokémon have a secondary type that negates their weakness to Water-type attacks. On the other hand, most Fire types can learn Solar Beam to counter all three of the type's weaknesses.\n" +
                "\n" +
                "The Fire type grants immunity to burns and the sea of fire caused by Grass Pledge and Fire Pledge. It enables the use of Burn Up, though Burn Up removes the user's Fire type.","During harsh sunlight or extremely harsh sunlight, the power of Fire-type attacks is increased by 50%. The power of Fire-type attacks is decreased by 50% during rain, while all Fire-type moves will fail during heavy rain. When Water Sport is in the effect, the power of Fire-type moves are decreased by 50%. When used under the effect of Powder, Fire attacks will damage the user by 1/4 of its max HP instead of executing normally.\n" +
                "\n" +
                "Because Fire is super effective against Grass and Bug, it combines well with Ground-type attacks.","In Contests, Fire-type moves are typically Beautiful moves.","https://cdn.bulbagarden.net/upload/0/0e/GO_Fire.png"
        ));
        listElement.add(new Element(
                "Water","The Water type (Japanese: みずタイプ Water type) is one of the eighteen types. Prior to changes in Generation IV, all damaging Water-type moves were special, but they may now also be physical depending on the attack.","Freeze-Dry is a unique Ice-type move that is super effective against Water, regardless of its actual type. The move Soak changes its target's type(s) to Water.\n" +
                "\n" +
                "Water-type Pokémon fares well defensively, being weak to only Electric and Grass-type moves.","Almost all Water-type Pokémon can learn strong Ice-type moves to deal with Dragon and Grass types. Flying also has good coverage with Water attacks. Though not a type, Freeze-Dry has even better coverage with Water, as every type that resists water is weak to Freeze-Dry. A Pokémon can resist this combination only when aided by an Ability, such as Water Absorb.\n" +
                "\n" +
                "Weather can affect Water-type moves, with rain boosting its power and harsh sunlight reducing it, while extremely harsh sunlight causes Water-type moves to fail completely.","In Contests, Water-type moves are typically Beautiful moves, but they can be from any other Contest type.","https://cdn.bulbagarden.net/upload/a/aa/GO_Water.png"
        ));
        listElement.add(new Element(
                "Grass","The Grass type (Japanese: くさタイプ Grass type) is one of the eighteen types. Prior to changes in Generation IV, all damaging Grass-type moves were special, but they may now also be physical depending on the attack.","Grass types are tied with Rock in having the most weaknesses out of all types with five.\n" +
                "\n" +
                "Since Generation I, a particular asset of Grass types is being the only type that is immune to Leech Seed. As of Generation VI, Grass-type Pokémon are also immune to powder and spore moves, such as Sleep Powder and Stun Spore. Additionally, Grass Pokémon are the only ones affected by Rototiller and Flower Shield. Those moves raise both attack stats or the physical Defense stat, respectively, when used.\n" +
                "\n" +
                "Forest's Curse adds the Grass type to the target's types.","Grass-type attacks are resisted by seven types, so they're tied with Bug as the most resisted type. Those resistant types are best covered by Rock and Ground. As of Generation VI, Dark and Ghost have neutral matchups against every type that resists Grass.\n" +
                "\n" +
                "When Grassy Terrain is in the effect, the power of Grass-type moves is increased by 30% (50% prior to Generation VIII) if the user is on the ground.","In contests, Grass-type moves are typically Clever moves, but can also be any of the other four contest conditions.","https://cdn.bulbagarden.net/upload/6/61/GO_Grass.png"
        ));
        listElement.add(new Element(
                "Electric","The Electric type (Japanese: でんきタイプ Electric type) is one of the eighteen types. Prior to changes in Generation IV, all damaging Electric-type moves were special, but they may now also be physical depending on the attack","Electric is tied with the Normal type for having the fewest weaknesses. Because of their single weakness to Ground, it is possible for pure Electric-type Pokémon to have no weaknesses by becoming airborne through having the Ability Levitate (for example, Eelektross), the held item Air Balloon, or being under the effect of Magnet Rise or Telekinesis. As of Generation VI, Electric-type Pokémon are immune to paralysis.","The Electric type pairs well with other common attacking types, especially Ice because it is super-effective against Ground (which Electric has no effect on), as well as the Electric-resistant Grass and Dragon.\n" +
                "\n" +
                "When Electric Terrain is in effect, the power of Electric-type moves is increased by 30% (50% prior to Generation VIII) if the user is on the ground. When Mud Sport is in effect, the power of Electric-type moves used on Pokémon affected by Mud Sport is decreased by 50%. All Normal moves become Electric moves when affected by Ion Deluge or Plasma Fists, and all of a Pokémon's moves become Electric moves when that Pokémon is affected by Electrify.","When used in Contests, Electric-type moves tend to be Cool moves, though they can also be other conditions.","https://cdn.bulbagarden.net/upload/4/4a/GO_Electric.png"
        ));
        listElement.add(new Element(
                "Psychic","The Psychic type (Japanese: エスパータイプ Esper type) is one of the eighteen types. Prior to changes in Generation IV, all damaging Psychic-type moves were special, but they may also now be physical depending on the attack.","Prior to Generation VI, Steel/Psychic types were exempt from Psychic's three weaknesses, but since Steel no longer resists Dark and Ghost, this is no longer the case.","A drawback of Psychic-type moves is that they do not affect Dark-type Pokémon, although this immunity can be removed with Miracle Eye. The immunity, along with resistances to Psychic, can also be circumvented with coverage moves such as Ground-type attacks.\n" +
                "\n" +
                "When Psychic Terrain is in effect, the power of Psychic-type moves are increased by 30% (50% prior to Generation VIII) if the user is on the ground.","When used in Contests, Psychic-type moves are typically Clever moves, but can also be of the other four Contest types, excluding Tough.","https://cdn.bulbagarden.net/upload/f/f2/GO_Psychic.png"
        ));
        listElement.add(new Element(
                "Ice","The Ice type (Japanese: こおりタイプ Ice type) is one of the eighteen types. Prior to changes in Generation IV, all damaging Ice-type moves were special, but they may now also be physical depending on the attack.","Resisting only itself, the Ice type is tied with Normal as the least-resistant type. However, it is immune to freezing, damage from hail, and Sheer Cold (as of Generation VII).","Ice pairs well with other common attacking types, most notably Ground, which deals at least neutral damage to all types resisting Ice and covers Fire and Steel while Ice covers Flying and Grass. As of Generation VII, Sheer Cold is more accurate when used by an Ice Pokémon.","When used in Pokémon Contests, most Ice-type moves become Beautiful moves, with one Cool move being the only exception.","https://cdn.bulbagarden.net/upload/c/c6/GO_Ice.png"
        ));
        listElement.add(new Element(
                "Dragon","The Dragon type (Japanese: ドラゴンタイプ Dragon type) is one of the eighteen types. Prior to changes in Generation IV, all damaging Dragon-type moves were special, but they may now also be physical depending on the attack.","Many Dragon Pokémon are pseudo-legendary or Legendary Pokémon. Partly because of this, Dragon Pokémon have the highest average HP and base stat total of all types","In addition to HP, Dragon-type Pokémon have the highest average Special Attack of all types of Pokémon and fully-evolved Pokémon. Dragon is tied with Ghost for the type with the least resistance.\n" +
                "\n" +
                "The Dragon type can only deal super-effective damage to itself.\n" +
                "\n" +
                "When Misty Terrain is in the effect, the power of Dragon-type moves is decreased by 50% if the target is on the ground.","In Contests, Dragon-type moves are typically Cool moves, but some may be Beautiful or Tough. None of them are Cute or Clever moves.","https://cdn.bulbagarden.net/upload/9/90/GO_Dragon.png"
        ));
        listElement.add(new Element(
                "Dark","The Dark type (Japanese: あくタイプ Evil type) is one of the eighteen types. Prior to changes in Generation IV, all damaging Dark-type moves were special, but they may now also be physical depending on the attack.\n" +
                "\n" +
                "The Dark type was introduced in Generation II, along with the Steel type.","The Dark type, along with the Steel type, was introduced in Generation II in order to balance against Psychic type, so it is immune to Psychic attacks. However, this immunity is nullified by Miracle Eye. Dark Pokémon have a single Ground weakness if their other type is Poison, which nullifies all of Dark type's other weaknesses. Dark Pokémon are immune to opposing Pokémon's moves that gain priority due to Prankster, including moves called by moves that call other moves (such as Assist and Nature Power) and excluding moves that are repeated as a result of Prankster-affected Instruct.","Dark-type attacks are resisted by Fighting, Dark, and Fairy, so using them along with Fairy attacks will optimize neutral coverage.","In Contests, Dark-type moves are typically categorized as Clever moves.","https://cdn.bulbagarden.net/upload/7/73/GO_Dark.png"
        ));
        listElement.add(new Element(
                "Fairy","The Fairy type (Japanese: フェアリータイプ Fairy type) is one of the eighteen types.\n" +
                "\n" +
                "The Fairy type was introduced in Generation VI. As well as introducing new Pokémon with the Fairy type, 22 Pokémon and three moves were changed to be of the Fairy type.","The Pokémon of this type have the highest average Special Defense of all types.\n" +
                "\n" +
                "The Fairy type is also immune to Dragon-type damage.","Fairy attacks are resisted by Poison, but Poison is weak to Psychic-type moves, which Fairy Pokémon are frequently able to learn. Additionally, all three of the types that resist Fairy are weak to Ground, making Fairy and Ground a strong attacking combination.\n" +
                "\n" +
                "Fairy-type Pokémon, on average, have the lowest physical Attack of all Pokémon.","In Contests, Fairy-type moves are typically Beautiful and Cute moves. None of them are considered Cool or Tough moves.","https://cdn.bulbagarden.net/upload/a/ae/GO_Fairy.png"
        ));

        elementAdapter = new ElementAdapter(listElement);
        elementAdapter.setListener(this);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        rv.setAdapter(elementAdapter);
        rv.setLayoutManager(layoutManager);
    }

    public void back(View view) {
        Intent i = new Intent(ElementActivity.this, MainActivity.class);
        startActivity(i);
    }

    @Override
    public void onClick(View view, int position) {
        Element element = listElement.get(position);
        Intent i = new Intent(ElementActivity.this, ElementDetailActivity.class);
        i.putExtra(Key_ElementActivity, element);
        startActivity(i);
    }
}