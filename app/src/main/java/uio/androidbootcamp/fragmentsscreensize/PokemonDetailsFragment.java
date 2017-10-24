package uio.androidbootcamp.fragmentsscreensize;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class PokemonDetailsFragment extends Fragment {
    private static final String POKEMON_ID = "pokemonId";

    private String itemId;

    public PokemonDetailsFragment() {
        // Required empty public constructor
    }

    public static PokemonDetailsFragment newInstance(String itemId) {
        PokemonDetailsFragment fragment = new PokemonDetailsFragment();
        Bundle args = new Bundle();
        args.putString(POKEMON_ID, itemId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            itemId = getArguments().getString(POKEMON_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pokemon_details, container, false);

        TextView itemNameTextView = view.findViewById(R.id.text_view_pokemon_name);
        TextView droidDescriptionTextView = view.findViewById(R.id.text_view_pokemon_description);

        itemNameTextView.setText(getName());
        itemNameTextView.setCompoundDrawablesWithIntrinsicBounds(geImage(), 0, 0, 0);
        droidDescriptionTextView.setText(getDescription());

        return view;
    }

    private Integer getDescription() {
        Map<String, Integer> droidsDescriptions = new HashMap<>();
        droidsDescriptions.put("bulbasaur", R.string.bulbasaur_descripcion);
        droidsDescriptions.put("charmander", R.string.charmander_descripcion);
        droidsDescriptions.put("pikachu", R.string.pikachu_descripcion);
        droidsDescriptions.put("squirtle", R.string.squirtle_descripcion);
        return droidsDescriptions.get(itemId);
    }

    private Integer geImage() {
        Map<String, Integer> droidsImages = new HashMap<>();
        droidsImages.put("bulbasaur", R.drawable.ic_bulbasaur);
        droidsImages.put("charmander", R.drawable.ic_charmander);
        droidsImages.put("pikachu", R.drawable.ic_pikachu);
        droidsImages.put("squirtle", R.drawable.ic_squirtle);
        return droidsImages.get(itemId);
    }

    private Integer getName() {
        Map<String, Integer> droidsNames = new HashMap<>();
        droidsNames.put("bulbasaur", R.string.bulbasaur);
        droidsNames.put("charmander", R.string.charmander);
        droidsNames.put("pikachu", R.string.pikachu);
        droidsNames.put("squirtle", R.string.squirtle);
        return droidsNames.get(itemId);
    }
}
