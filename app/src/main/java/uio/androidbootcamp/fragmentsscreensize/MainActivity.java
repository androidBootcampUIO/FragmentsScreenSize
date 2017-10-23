package uio.androidbootcamp.fragmentsscreensize;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements
        PokemonFragment.OnPokemonFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PokemonFragment pokemonFragment = PokemonFragment.newInstance();
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, pokemonFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onPokemonClicked(String pokemon) {
        Toast.makeText(this, pokemon, Toast.LENGTH_LONG).show();
    }
}
