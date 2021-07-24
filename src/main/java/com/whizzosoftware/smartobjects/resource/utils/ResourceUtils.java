package com.whizzosoftware.smartobjects.resource.utils;

import com.whizzosoftware.smartobjects.resource.ResourceConstants;

public class ResourceUtils {
    
    public static String toName(int id) {
    	String value = null;
    	if( id == ResourceConstants.DigitalOutputState) {
    		value=   "Digital Output State";
    	}
        if( id == ResourceConstants.DigitalInputState ){
    		value=   "Digital Input State";
    	}
        if( id == ResourceConstants.DigitalInputCounter ){
    		value=   "Digital Output State";
    	}
        if( id == ResourceConstants.DigitalInputPolarity ){
    		value=   "Digital Output State";
    	}
        if( id == ResourceConstants.DigitalInputDebouncePeriodInMs  ){
    		value=   "Digital Output State";
    	}
        if( id == ResourceConstants.DigitalInputEdgeSelection  ){
    		value=   "Digital Output State";
    	}
        if( id == ResourceConstants.DigitalInputCounterReset ){
    		value=   "Digital Output State";
    	}
        if( id == ResourceConstants.DigitalOutputState ){
    		value=   "Digital Output State";
    	}
        if( id == ResourceConstants.DigitalOutputPolarity  ){
    		value=   "Digital Output State";
    	}
        /*
        if( id == ResourceConstants.AnalogInputCurrentValue = 5600;
        if( id == ResourceConstants.MinMeasuredValue = 5601;
        if( id == ResourceConstants.MaxMeasuredValue = 5602;
        if( id == ResourceConstants.MinRangeValue = 5603;
        if( id == ResourceConstants.MaxRangeValue = 5604;
        if( id == ResourceConstants.ResetMinAndMaxMeasuredValues = 5605;
        if( id == ResourceConstants.AnalogOutputCurrentValue = 5650;
        if( id == ResourceConstants.SensorValue = 5700;
        if( id == ResourceConstants.Units = 5701;
        if( id == ResourceConstants.XValue = 5702;
        if( id == ResourceConstants.YValue = 5703;
        if( id == ResourceConstants.ZValue = 5704;
        if( id == ResourceConstants.CompassDirection = 5705;
        if( id == ResourceConstants.Colour = 5706;
        if( id == ResourceConstants.ApplicationType = 5750;
        if( id == ResourceConstants.SensorType = 5751;
        if( id == ResourceConstants.InstantaneousActivePower = 5800;
        if( id == ResourceConstants.MinMeasuredActivePower = 5801;
        if( id == ResourceConstants.MaxMeasuredActivePower = 5802;
        if( id == ResourceConstants.MinRangeActivePower = 5803;
        if( id == ResourceConstants.MaxRangeActivePower = 5804;
        if( id == ResourceConstants.CumulativeActivePower = 5805;
        if( id == ResourceConstants.ActivePowerCalibration = 5806;
        if( id == ResourceConstants.InstantaneousReactivePower = 5810;
        if( id == ResourceConstants.MinMeasuredReactivePower = 5811;
        if( id == ResourceConstants.MaxMeasuredReactivePower = 5812;
        if( id == ResourceConstants.MinRangeReactivePower = 5813;
        if( id == ResourceConstants.MaxRangeReactivePower = 5814;
        if( id == ResourceConstants.CumulativeReactivePower = 5815;
        if( id == ResourceConstants.ReactivePowerCalibration = 5816;
        if( id == ResourceConstants.PowerFactor = 5820;
        if( id == ResourceConstants.CurrentCalibration = 5821;
        if( id == ResourceConstants.ResetCumulativeEnergy = 5822;
        if( id == ResourceConstants.EventIdentifier = 5823;
        if( id == ResourceConstants.StartTime = 5824;
        if( id == ResourceConstants.DurationInMin = 5825;
        if( id == ResourceConstants.CriticalityLevel = 5826;
        if( id == ResourceConstants.AvgLoadAdjPct = 5827;
        if( id == ResourceConstants.DutyCycle = 5828;
        if( id == ResourceConstants.OnOff = 5850;
        if( id == ResourceConstants.Dimmer = 5851;
        if( id == ResourceConstants.OnTime = 5852;
        if( id == ResourceConstants.MultiStateOutput = 5853;
        if( id == ResourceConstants.SetPointValue = 5900;
        if( id == ResourceConstants.BusyToClearDelay = 5903;
        if( id == ResourceConstants.ClearToBusyDelay = 5904;
        */
    	return value;
    }
}
