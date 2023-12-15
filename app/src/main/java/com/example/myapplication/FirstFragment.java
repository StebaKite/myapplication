package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myapplication.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    TextView showCountTextView;


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.random_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentCount = Integer.parseInt(showCountTextView.getText().toString());
                FirstFragmentDirections.ActionFirstFragmentToSecondFragment action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(currentCount);
                NavHostFragment.findNavController(FirstFragment.this).navigate(action);
            }
        });

        view.findViewById(R.id.toast_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast myToast = Toast.makeText(getActivity(), R.string.toast_message, Toast.LENGTH_SHORT);
                myToast.show();
            }
        });

        view.findViewById(R.id.count_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countMe(view);
            }
        });

    }

    /*
    Potresti chiamare findViewById() in countMe() per trovare showCountTextView.
    Tuttavia, countMe() viene chiamato ogni volta che si fa clic sul pulsante e findViewById()
    è un metodo relativamente dispendioso in termini di tempo da chiamare.
    Quindi è meglio trovare la view la prima volta e memorizzarla nella cache.

    Quindi: nn onCreateView(), chiamerai findViewById() per ottenere TextView che mostra il conteggio.
    Il metodo findViewById() deve essere chiamato su una vista in cui dovrebbe iniziare la ricerca dell'ID richiesto,
    quindi assegna la vista di layout attualmente restituita a una nuova variabile, fragmentFirstLayout.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentFirstLayout = inflater.inflate(R.layout.fragment_first, container, false);
        showCountTextView = fragmentFirstLayout.findViewById(R.id.textview_first);
        return fragmentFirstLayout;
    }

    public void countMe(View view) {
        // Prendo il valore dell'oggetto
        String countString = showCountTextView.getText().toString();

        // converto il valore prelevato dall'oggetto in Intero e incremento il valore di uno
        Integer count = Integer.parseInt(countString);
        count++;

        // imposto il valore dell'oggetto con il nuovo valore incrementato
        showCountTextView.setText(count.toString());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}