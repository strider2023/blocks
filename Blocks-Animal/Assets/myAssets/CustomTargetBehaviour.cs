using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using Vuforia;
using UnityEngine.UI;

public class CustomTargetBehaviour : MonoBehaviour
{
    DefaultTrackableEventHandler trackerObj;

    public GameObject cube,arcam,head;
	// Use this for initialization
	void Start ()
    {
        GameObject.Find("notation").GetComponent<Text>().text = "";
        trackerObj = this.GetComponent<DefaultTrackableEventHandler>();
	}
	
	// Update is called once per frame
	void Update ()
    {
       
        CameraDevice.Instance.SetFocusMode(CameraDevice.FocusMode.FOCUS_MODE_CONTINUOUSAUTO);
        if (trackerObj.isTriggered)
        {         
            cube.SetActive(true);
            GameObject.Find("notation").GetComponent<Text>().text = "tracked";
            //GameObject.Find("arcamera").GetComponent<Text>().text = "ar= "+arcam.transform.localEulerAngles;
            //GameObject.Find("head").GetComponent<Text>().text = "head= " + head.transform.localEulerAngles;
            
        }
        //if (trackerObj.isTriggerLost)
        //{
        //    //TrackerManager.Instance.GetTracker<ObjectTracker>().Stop();
        //    //cube.transform.localPosition = new Vector3(0, 1.5f, 0);
        //    ////if(!TrackerManager.Instance.GetTracker<DeviceTracker>().IsActive)
        //    ////TrackerManager.Instance.GetTracker<DeviceTracker>().Start();
        //}

    }


}
