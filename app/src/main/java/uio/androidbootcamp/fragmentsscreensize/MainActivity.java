package uio.androidbootcamp.fragmentsscreensize;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements
        PokemonFragment.OnPokemonFragmentInteractionListener {

    private int second_fragment_container;
    private int first_fragment_container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        first_fragment_container = R.id.fragment_container;
        second_fragment_container = R.id.second_fragment_container;

        PokemonFragment pokemonFragment = PokemonFragment.newInstance();
        showFragment(pokemonFragment, null, first_fragment_container);
    }

    private boolean hasTwoPanels() {
        return findViewById(second_fragment_container) != null;
    }

    private void showFragment(Fragment fragment, String tag, int target) {
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(target, fragment);
        if (tag != null) {
            fragmentTransaction.addToBackStack(tag);
        }
        fragmentTransaction.commit();
    }

    @Override
    public void onPokemonClicked(String pokemon) {
        PokemonDetailsFragment pokemonDetailsFragment = PokemonDetailsFragment.newInstance(pokemon);

        if (hasTwoPanels()) {
            showFragment(pokemonDetailsFragment, "pokemon", second_fragment_container);
        } else {
            showFragment(pokemonDetailsFragment, "pokemon", first_fragment_container);
        }
    }
}
