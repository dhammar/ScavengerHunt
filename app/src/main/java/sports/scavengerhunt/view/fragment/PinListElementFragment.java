package sports.scavengerhunt.view.fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import sports.scavengerhunt.R;
import sports.scavengerhunt.data.Pin;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PinListElementFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PinListElementFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PinListElementFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String PIN_DESC_KEY = "pin_desc_key";
    private static final String PIN_LAT_KEY = "pin_lat_key";
    private static final String PIN_LONG_KEY = "pin_long_key";
    // TODO: Rename and change types of parameters
    private String desc;
    private String latCoord;
    private String longCoord;
    private OnFragmentInteractionListener mListener;
    private Activity parent;

    public PinListElementFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment PinListElementFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PinListElementFragment newInstance(Pin p) {
        PinListElementFragment fragment = new PinListElementFragment();
        Bundle args = new Bundle();
        args.putString(PIN_DESC_KEY, p.getDescription());
        args.putString(PIN_LAT_KEY, p.getLat());
        args.putString(PIN_LONG_KEY, p.getLong());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            desc = getArguments().getString(PIN_DESC_KEY);
            latCoord = getArguments().getString(PIN_LAT_KEY);
            longCoord = getArguments().getString(PIN_LONG_KEY);
        }
    }

    public void setHeat(Heat heat){
        heatButton.setBackgroundResource(heat.getColor());
    }


    private TextView descriptionText;
    private Button heatButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflatedView = inflater.inflate(R.layout.fragment_pin_list_element, container, false);
        descriptionText = (TextView)container.findViewById(R.id.location_description_text);
        heatButton = (Button)container.findViewById(R.id.location_heat_display);
        heatButton.setBackgroundResource(R.color.button_grey);
        return inflatedView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public enum Heat{
        COLD(R.color.location_heat_color_cold), COOL(R.color.location_heat_color_cool),
        NEUTRAL(R.color.location_heat_color_neutral), WARM(R.color.location_heat_color_warm),
        HOT(R.color.location_heat_color_cool), COMPLETE(R.color.location_heat_color_complete),
        UNKNOWN(R.color.button_grey);

        private final int COLOR;

        Heat(int color){
            COLOR = color;
        }

        public int getColor(){
            return COLOR;
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
