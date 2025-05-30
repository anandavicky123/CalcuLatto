package com.softgasm.calculatto.contents.independents;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import com.softgasm.calculatto.R;
import com.softgasm.calculatto.system.Filters;
import com.softgasm.calculatto.system.adapter.NoSymmetricAndPositiveException;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import Jama.EigenvalueDecomposition;
import Jama.LUDecomposition;
import Jama.Matrix;
import Jama.QRDecomposition;
import Jama.SingularValueDecomposition;


public class matrix extends Fragment {

    View view;

    EditText matrix_a, matrix_b;

    AppCompatButton inst, resall, res_a, res_b, calculate;

    TextView tr;
    ScrollView sv;

    LinearLayout matrix_b_linear;

    Spinner cond, oneortwo;

    Matrix res;

    boolean customresult;

    final NumberFormat format = new DecimalFormat("0.######");

    public matrix() {
        // Required empty public constructor
    }


    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_matrix, container, false);

        matrix_a = view.findViewById(R.id.matrix_first);
        matrix_b = view.findViewById(R.id.matrix_second);
        inst = view.findViewById(R.id.matrix_inst);
        resall = view.findViewById(R.id.matrix_resall);
        res_a = view.findViewById(R.id.matrix_reset_first);
        res_b = view.findViewById(R.id.matrix_reset_second);
        calculate = view.findViewById(R.id.matrix_calculate);
        tr = view.findViewById(R.id.matrix_result);
        sv = view.findViewById(R.id.matrix_scrollview);
        cond = view.findViewById(R.id.matrix_condition);
        oneortwo = view.findViewById(R.id.matrix1or2);
        matrix_b_linear = view.findViewById(R.id.safafd1);


        String[] lista = {("2 (A & B)"), ("1 (A)")};
        ArrayAdapter<String> adaptera = new ArrayAdapter<>(
                requireContext(), android.R.layout.simple_spinner_dropdown_item, lista);
        oneortwo.setAdapter(adaptera);

        String[] list = {(getString(R.string.addition)), (getString(R.string.subtraction)), (getString(R.string.multiply)), (getString(R.string.divide))};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireContext(), R.layout.view_matrixspinner, list);

        cond.setAdapter(adapter);

        String[] list1 = {(getString(R.string.number)), (getString(R.string.inverse)), (getString(R.string.transpose)), ("Cholesky"), (getString(R.string.eigenvalue)), ("LU"), ("QR"), ("SVD")};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(
                requireContext(), R.layout.view_matrixspinner, list1);

        inst.setOnClickListener(v -> {
            final Dialog dialog = new Dialog(requireContext());
            dialog.setContentView(R.layout.dialog_matrix);
            dialog.setTitle(R.string.instructions);
            dialog.show();

            Button back = dialog.findViewById(R.id.matrix_inst_back);
            back.setOnClickListener(v1 -> dialog.dismiss());
        });


        oneortwo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 1) {
                    tr.setText("");
                    matrix_b_linear.setVisibility(View.GONE);
                    matrix_b.setVisibility(View.GONE);
                    cond.setAdapter(adapter1);
                } else {
                    tr.setText("");
                    matrix_b_linear.setVisibility(View.VISIBLE);
                    matrix_b.setVisibility(View.VISIBLE);
                    cond.setAdapter(adapter);
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        res_a.setOnClickListener(v -> {
            matrix_a.setText("");
        });
        res_b.setOnClickListener(v -> {
            matrix_b.setText("");
        });
        resall.setOnClickListener(v -> {
            matrix_a.setText("");
            matrix_b.setText("");
            tr.setText("");
        });


        calculate.setOnClickListener(v -> {

            customresult = false;
            tr.setText("");
            String ma = matrix_a.getText().toString();
            String mb = matrix_b.getText().toString();

            // get the lines
            if (!ma.isEmpty()) {
                try {
                    String aa = ma;
                    aa = aa.replaceAll(", ", " ");
                    aa = aa.replaceAll(",", " ");
                    // get the lines
                    String[] lines1 = aa.split("\\r?\\n");

                    // get the max amt of nums in the file in a single line
                    int maxInLine = 0;
                    for (String x : lines1) {
                        String[] temp = x.split("\\s+"); // split on whitespace
                        if (temp.length > maxInLine) {
                            maxInLine = temp.length;
                        }
                    }

                    String[][] matrix_1 = new String[lines1.length][maxInLine]; // declare and instantiate the array of arrays

                    // standard double for loop to fill up your 2D array
                    for (int i = 0; i < lines1.length; i++) {
                        String[] temp = lines1[i].split("\\s+");
                        System.arraycopy(temp, 0, matrix_1[i], 0, temp.length);
                    }


                    double[][] matrix1 = new double[matrix_1.length][matrix_1[0].length];

                    for (int i = 0; i < matrix_1.length; i++) {
                        for (int j = 0; j < matrix_1[0].length; j++) {
                            matrix1[i][j] = Double.parseDouble(matrix_1[i][j]);
                        }
                    }

                    Matrix aaa = new Matrix(matrix1);


                    if (oneortwo.getSelectedItemPosition() == 1) {
                        switch (cond.getSelectedItemPosition()) {
                            case 1:
                                res = aaa.inverse();
                                break;
                            case 2:
                                res = aaa.transpose();
                                break;
                            case 3:
                                if (aaa.chol().isSPD()) {
                                    res = aaa.chol().getL();
                                } else {
                                    throw new NoSymmetricAndPositiveException();
                                }
                                break;
                            case 4: {
                                customresult = true;
                                EigenvalueDecomposition a11 = aaa.eig();
                                res = a11.getV();
                                Matrix uuu = a11.getD();


                                double[][] ress = res.getArrayCopy();
                                double[][] ress1 = uuu.getArrayCopy();
                                String[][] saaaa = new String[ress.length][];
                                for (int i = 0; i < ress.length; i++) {
                                    saaaa[i] = new String[ress[i].length];
                                    for (int j = 0; j < ress[i].length; j++) {
                                        saaaa[i][j] = format.format(ress[i][j]);
                                    }
                                }
                                String[][] saaaa1 = new String[ress1.length][];
                                for (int i = 0; i < ress1.length; i++) {
                                    saaaa1[i] = new String[ress1[i].length];
                                    for (int j = 0; j < ress1[i].length; j++) {
                                        saaaa1[i][j] = format.format(ress1[i][j]);
                                    }
                                }


                                StringBuilder builder = new StringBuilder();
                                for (String[] strings : saaaa) {
                                    for (int j = 0; j < saaaa[0].length; j++)
                                        builder.append(strings[j]).append("  ");
                                    builder.append("\n"); // Append newline after every row
                                }

                                StringBuilder builder1 = new StringBuilder();
                                for (String[] strings1 : saaaa1) {
                                    for (int j = 0; j < saaaa1[0].length; j++)
                                        builder1.append(strings1[j]).append("  ");
                                    builder1.append("\n"); // Append newline after every row
                                }


                                double[] real = a11.getRealEigenvalues();
                                StringBuilder realsb = new StringBuilder();
                                for (double process11 : real)
                                    realsb.append(format.format(process11)).append(", ");
                                realsb.setLength(realsb.length() - 2);
                                double[] imagine = a11.getImagEigenvalues();
                                StringBuilder imagesb = new StringBuilder();
                                for (double process22 : imagine)
                                    imagesb.append(format.format(process22)).append(", ");
                                imagesb.setLength(imagesb.length() - 2);
                                tr.setText(getString(R.string.eigenvector) + ":\n" + builder + "\n" + getString(R.string.blockdiagonal) + ":\n" + builder1 + "\n" + getString(R.string.realpart) + ": " + realsb + "\n" + getString(R.string.imaginary) + ": " + imagesb);
                            }

                            break;
                            case 5: {
                                customresult = true;
                                LUDecomposition a12 = aaa.lu();
                                res = a12.getL();
                                Matrix uuu = a12.getU();


                                double[][] ress = res.getArrayCopy();
                                double[][] ress1 = uuu.getArrayCopy();
                                String[][] saaaa = new String[ress.length][];
                                for (int i = 0; i < ress.length; i++) {
                                    saaaa[i] = new String[ress[i].length];
                                    for (int j = 0; j < ress[i].length; j++) {
                                        saaaa[i][j] = format.format(ress[i][j]);
                                    }
                                }
                                String[][] saaaa1 = new String[ress1.length][];
                                for (int i = 0; i < ress1.length; i++) {
                                    saaaa1[i] = new String[ress1[i].length];
                                    for (int j = 0; j < ress1[i].length; j++) {
                                        saaaa1[i][j] = format.format(ress1[i][j]);
                                    }
                                }


                                StringBuilder builder = new StringBuilder();
                                for (String[] strings : saaaa) {
                                    for (int j = 0; j < saaaa[0].length; j++)
                                        builder.append(strings[j]).append("  ");
                                    builder.append("\n"); // Append newline after every row
                                }

                                StringBuilder builder1 = new StringBuilder();
                                for (String[] strings1 : saaaa1) {
                                    for (int j = 0; j < saaaa1[0].length; j++)
                                        builder1.append(strings1[j]).append("  ");
                                    builder1.append("\n"); // Append newline after every row
                                }


                                double[] pivot = a12.getDoublePivot();
                                StringBuilder pivsd = new StringBuilder();
                                for (double process11 : pivot)
                                    pivsd.append(format.format(process11)).append(", ");
                                pivsd.setLength(pivsd.length() - 2);
                                double det1 = a12.det();
                                boolean nonsingular = a12.isNonsingular();
                                String nsres;
                                if (nonsingular) {
                                    nsres = getString(R.string.yes);
                                } else {
                                    nsres = getString(R.string.no);
                                }
                                tr.setText("L: \t" + builder + "\nU: \t" + builder1 + "\n" + getString(R.string.determinant) + ": " + frd(det1) + "\n" + getString(R.string.nonsingularask) + ": " + nsres + "\n" + getString(R.string.permutationvector) + ": " + pivsd);
                            }
                            break;
                            case 6: {
                                customresult = true;
                                QRDecomposition a13 = aaa.qr();
                                res = a13.getH();
                                Matrix qr1 = a13.getQ();
                                Matrix qr2 = a13.getR();


                                double[][] ress = res.getArrayCopy();
                                double[][] ress1 = qr1.getArrayCopy();
                                double[][] ress2 = qr2.getArrayCopy();
                                String[][] saaaa = new String[ress.length][];
                                for (int i = 0; i < ress.length; i++) {
                                    saaaa[i] = new String[ress[i].length];
                                    for (int j = 0; j < ress[i].length; j++) {
                                        saaaa[i][j] = format.format(ress[i][j]);
                                    }
                                }
                                String[][] saaaa1 = new String[ress1.length][];
                                for (int i = 0; i < ress1.length; i++) {
                                    saaaa1[i] = new String[ress1[i].length];
                                    for (int j = 0; j < ress1[i].length; j++) {
                                        saaaa1[i][j] = format.format(ress1[i][j]);
                                    }
                                }
                                String[][] saaaa2 = new String[ress2.length][];
                                for (int i = 0; i < ress2.length; i++) {
                                    saaaa2[i] = new String[ress2[i].length];
                                    for (int j = 0; j < ress2[i].length; j++) {
                                        saaaa2[i][j] = format.format(ress2[i][j]);
                                    }
                                }


                                StringBuilder builder = new StringBuilder();
                                for (String[] strings : saaaa) {
                                    for (int j = 0; j < saaaa[0].length; j++)
                                        builder.append(strings[j]).append("  ");
                                    builder.append("\n"); // Append newline after every row
                                }

                                StringBuilder builder1 = new StringBuilder();
                                for (String[] strings1 : saaaa1) {
                                    for (int j = 0; j < saaaa1[0].length; j++)
                                        builder1.append(strings1[j]).append("  ");
                                    builder1.append("\n"); // Append newline after every row
                                }

                                StringBuilder builder2 = new StringBuilder();
                                for (String[] strings2 : saaaa2) {
                                    for (int j = 0; j < saaaa2[0].length; j++)
                                        builder2.append(strings2[j]).append("  ");
                                    builder2.append("\n"); // Append newline after every row
                                }


                                boolean nonsingular = a13.isFullRank();
                                String nsres;
                                if (nonsingular) {
                                    nsres = getString(R.string.yes);
                                } else {
                                    nsres = getString(R.string.no);
                                }
                                tr.setText("Q: \t" + builder1 + "\nR: \t" + builder2 + "\nH: \t" + builder + "\n" + getString(R.string.fullrankask) + ": " + nsres);
                            }
                            break;
                            case 7: {
                                customresult = true;
                                SingularValueDecomposition a14 = aaa.svd();
                                res = a14.getU();
                                Matrix qr1 = a14.getS();
                                Matrix qr2 = a14.getV();


                                double[][] ress = res.getArrayCopy();
                                double[][] ress1 = qr1.getArrayCopy();
                                double[][] ress2 = qr2.getArrayCopy();
                                String[][] saaaa = new String[ress.length][];
                                for (int i = 0; i < ress.length; i++) {
                                    saaaa[i] = new String[ress[i].length];
                                    for (int j = 0; j < ress[i].length; j++) {
                                        saaaa[i][j] = format.format(ress[i][j]);
                                    }
                                }
                                String[][] saaaa1 = new String[ress1.length][];
                                for (int i = 0; i < ress1.length; i++) {
                                    saaaa1[i] = new String[ress1[i].length];
                                    for (int j = 0; j < ress1[i].length; j++) {
                                        saaaa1[i][j] = format.format(ress1[i][j]);
                                    }
                                }
                                String[][] saaaa2 = new String[ress2.length][];
                                for (int i = 0; i < ress2.length; i++) {
                                    saaaa2[i] = new String[ress2[i].length];
                                    for (int j = 0; j < ress2[i].length; j++) {
                                        saaaa2[i][j] = format.format(ress2[i][j]);
                                    }
                                }


                                StringBuilder builder = new StringBuilder();
                                for (String[] strings : saaaa) {
                                    for (int j = 0; j < saaaa[0].length; j++)
                                        builder.append(strings[j]).append("  ");
                                    builder.append("\n"); // Append newline after every row
                                }

                                StringBuilder builder1 = new StringBuilder();
                                for (String[] strings1 : saaaa1) {
                                    for (int j = 0; j < saaaa1[0].length; j++)
                                        builder1.append(strings1[j]).append("  ");
                                    builder1.append("\n"); // Append newline after every row
                                }

                                StringBuilder builder2 = new StringBuilder();
                                for (String[] strings2 : saaaa2) {
                                    for (int j = 0; j < saaaa2[0].length; j++)
                                        builder2.append(strings2[j]).append("  ");
                                    builder2.append("\n"); // Append newline after every row
                                }


                                double[] sv = a14.getSingularValues();
                                StringBuilder svsb = new StringBuilder();
                                for (double process11 : sv)
                                    svsb.append(format.format(process11)).append(", ");
                                svsb.setLength(svsb.length() - 2);
                                double norm2 = a14.norm2();
                                int rank = a14.rank();
                                tr.setText("U: \t" + builder + "\nΣ: \t" + builder1 + "\nV: \t" + builder2 + "\n" + "∥A∥₂" + ": " + frd(norm2) + "\n" + getString(R.string.rank) + ": " + rank + "\n" + getString(R.string.singularvalues) + ": " + svsb);
                            }
                            break;

                        }

                    } else {
                        //Matrix 2
                        String bb = mb;
                        bb = bb.replaceAll(", ", " ");
                        bb = bb.replaceAll(",", " ");
                        String[] lines2 = bb.split("\\r?\\n");

                        int maxInLine1 = 0;
                        for (String x : lines2) {
                            String[] temp1 = x.split("\\s+"); // split on whitespace
                            if (temp1.length > maxInLine1) {
                                maxInLine1 = temp1.length;
                            }
                        }

                        String[][] matrix_2 = new String[lines2.length][maxInLine1]; // declare and instantiate the array of arrays

                        for (int i = 0; i < lines2.length; i++) {
                            String[] temp2 = lines2[i].split("\\s+");
                            System.arraycopy(temp2, 0, matrix_2[i], 0, temp2.length);
                        }


                        double[][] matrix2 = new double[matrix_2.length][matrix_2[0].length];

                        for (int i = 0; i < matrix_2.length; i++) {
                            for (int j = 0; j < matrix_2[0].length; j++) {
                                matrix2[i][j] = Double.parseDouble(matrix_2[i][j]);
                            }
                        }


                        Matrix bbb = new Matrix(matrix2);


                        switch (cond.getSelectedItemPosition()) {
                            case 1:
                                res = aaa.minus(bbb);
                                break;
                            case 2:
                                res = aaa.arrayTimes(bbb);
                                break;
                            case 3:
                                res = aaa.arrayRightDivide(bbb);
                                break;
                            case 4:
                                res = aaa.solve(bbb);
                                break;
                            default:
                                res = aaa.plus(bbb);
                                break;
                        }
                    }


                    if (!customresult) {
                        if (oneortwo.getSelectedItemPosition() == 1 && cond.getSelectedItemPosition() == 0) {
                            double determinant = 0;
                            boolean determinanterror = false;

                            try {
                                determinant = aaa.det();
                            } catch (ArrayIndexOutOfBoundsException e) {
                                determinanterror = true;
                            }
                            double rank = aaa.rank();
                            double trace = aaa.trace();
                            double norm1 = aaa.norm1();
                            double norm2 = aaa.norm2();
                            double normf = aaa.normF();
                            double norminf = aaa.normInf();
                            if (!determinanterror) {
                                tr.setText(getString(R.string.determinant) + ": " + frd(determinant) + "\n" + getString(R.string.rank) + ": " + frd(rank) + "\n" + getString(R.string.trace) + ": " + frd(trace) + "\n" + "∥A∥₁" + ": " + frd(norm1) + "\n" + "∥A∥₂" + ": " + frd(norm2) + "\n" + "∥A∥F" + ": " + frd(normf) + "\n" + "∥A∥∞" + ": " + frd(norminf));
                            } else {
                                tr.setText(getString(R.string.determinant) + ": " + getString(R.string.matrixnonsquareerror) + "\n" + getString(R.string.rank) + ": " + frd(rank) + "\n" + getString(R.string.trace) + ": " + frd(trace) + "\n" + "∥A∥₁" + ": " + frd(norm1) + "\n" + "∥A∥₂" + ": " + frd(norm2) + "\n" + "∥A∥F" + ": " + frd(normf) + "\n" + "∥A∥∞" + ": " + frd(norminf));
                            }


                        } else {
                            double[][] ress = res.getArrayCopy();

                            String[][] saaaa = new String[ress.length][];
                            for (int i = 0; i < ress.length; i++) {
                                saaaa[i] = new String[ress[i].length];
                                for (int j = 0; j < ress[i].length; j++) {
                                    saaaa[i][j] = format.format(ress[i][j]);
                                }
                            }


                            StringBuilder builder = new StringBuilder();
//                    // print
                            for (String[] strings : saaaa) {
                                for (int j = 0; j < saaaa[0].length; j++)
                                    builder.append(strings[j]).append("  ");
                                builder.append("\n"); // Append newline after every row
                            }
                            tr.setText(builder);
                        }
                    }


                    sv.post(() -> sv.fullScroll(View.FOCUS_DOWN));
                } catch (NumberFormatException e) {
                    Toast.makeText(requireContext(), getString(R.string.matrixerrornumberformat), Toast.LENGTH_LONG).show();
                } catch (NullPointerException e) {
                    Toast.makeText(requireContext(), getString(R.string.matrixerrornull), Toast.LENGTH_LONG).show();
                } catch (IllegalArgumentException e) {
                    tr.setText(getString(R.string.matrixdifferentsizeerror));
                    sv.post(() -> sv.fullScroll(View.FOCUS_DOWN));
                } catch (RuntimeException e) {
                    tr.setText(getString(R.string.matrixnonsquareerror));
                    sv.post(() -> sv.fullScroll(View.FOCUS_DOWN));
                } catch (NoSymmetricAndPositiveException e) {
                    tr.setText(getString(R.string.nosymmetricandpositive));
                    sv.post(() -> sv.fullScroll(View.FOCUS_DOWN));
                }
            }

        });
        return view;
    }

    private String frd(double result) {
        return Filters.rd(result);
    }


}