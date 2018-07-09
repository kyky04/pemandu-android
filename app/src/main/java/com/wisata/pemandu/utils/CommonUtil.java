package com.wisata.pemandu.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.CircularProgressDrawable;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;


public class CommonUtil {
    public static void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static void showSnack(Activity context, String message) {
        Snackbar.make(context.findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG)
                .setAction("Close", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                })
                .show();
    }

    public static void setImage(Context context, String url, ImageView imageView) {
        CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(context);
        circularProgressDrawable.setStrokeWidth(5.f);
        circularProgressDrawable.setCenterRadius(30f);
        circularProgressDrawable.start();

//        Glide.with(context).load(Constans.WEB_URL_IMAGE + url).placeholder(circularProgressDrawable).into(imageView);
    }

    public static void dialogTanggal(Context context, final EditText etDate) {
        final DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        TimeZone tz = TimeZone.getTimeZone("Asia/Jakarta");
        dateFormat.setTimeZone(tz);
        Calendar newCalendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                etDate.setText(dateFormat.format(newDate.getTime()));
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    public static String stringToDate(Date tanggal) {
        DateFormat format = new SimpleDateFormat("EEEE", Locale.ENGLISH);
        String day = format.format(tanggal);
        switch (day) {
            case "Sunday":
                day = "MINGGU";
                break;
            case "Monday":
                day = "SENIN";
                break;
            case "Tuesday":
                day = "SELASA";
                break;
            case "Wednesday":
                day = "RABU";
                break;
            case "Thursday":
                day = "KAMIS";
                break;
            case "Friday":
                day = "JUMAT";
                break;
        }
        return day;
    }

    public static void dialogTanggalFormat(Context context, final EditText etDate, final String format) {
        final DateFormat dateFormat = new SimpleDateFormat(format, Locale.ENGLISH);
        TimeZone tz = TimeZone.getTimeZone("Asia/Jakarta");
        dateFormat.setTimeZone(tz);
        Calendar newCalendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                etDate.setText(dateFormat.format(newDate.getTime()));

            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    public static String getCurrentDate(String fmt) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeZone(TimeZone.getTimeZone("Asia/Jakarta"));
        SimpleDateFormat format = new SimpleDateFormat(fmt);
//        Date date = new Date();
        return format.format(cal.getTime());
    }

    public static void dialogShow(Context context, String message, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(message);
        builder.setPositiveButton("OK", onClickListener);
        builder.setCancelable(false);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public static String getCurrentDate() {
        return getCurrentDate("yyyy-MM-dd");
    }

    public static String convertTanggalToHari(int num) {
        String hari = "";
        switch (num) {
            case 1:
                hari = "Senin";
                break;
            case 2:
                hari = "Selasa";
                break;
            case 3:
                hari = "Rabu";
                break;
            case 4:
                hari = "Kamis";
                break;
            case 5:
                hari = "Jumat";
                break;
            case 6:
                hari = "Sabtu";
                break;
            case 0:
                hari = "Minggu";
                break;
        }
        return hari;
    }

    public static String convertHari(int num) {
        String hari = "";
        switch (num) {
            case 1:
                hari = "SENIN";
                break;
            case 2:
                hari = "SELASA";
                break;
            case 3:
                hari = "RABU";
                break;
            case 4:
                hari = "KAMIS";
                break;
            case 5:
                hari = "JUMAT";
                break;
            case 6:
                hari = "SABTU";
                break;
            case 0:
                hari = "MINGGU";
                break;
        }
        return hari;
    }


    public static JSONObject convertStringToJson(String[] parameter, String[] value) {
        JSONObject jsonObject = new JSONObject();
        for (int i = 0; i < parameter.length; i++) {
            try {
                jsonObject.put(parameter[i], value[i]);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jsonObject;
    }

    public static boolean validateEmptyEntries(ArrayList<View> fields) {
        boolean check = true;
        for (int i = 0; i < fields.size(); i++) {
            EditText currentField = (EditText) fields.get(i);
            if (currentField.getText().toString().length() <= 0) {
                currentField.setError("Please fill out this field");
//                showToast("Please fill out this field");
                check = false;
            }
        }
        return check;
    }
}
