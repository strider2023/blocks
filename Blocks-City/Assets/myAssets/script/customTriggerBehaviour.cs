using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using Vuforia;

public class customTriggerBehaviour : MonoBehaviour
{
    DefaultTrackableEventHandler trackerObj;
    
    // Use this for initialization
    void Start()
    {
        InvokeRepeating("focus", .1f, 2);
        trackerObj = this.GetComponent<DefaultTrackableEventHandler>();
    }

    // Update is called once per frame
    void Update()
    {
        
        if (this.trackerObj.isTriggered)
        {
            this.transform.FindChild("model").gameObject.SetActive(true);    

            if (!trackerObj.alreadyTriggered)
            {
                this.transform.FindChild("model").GetComponent<modelBehaviour>().makeTrueForwardLerp(Vector3.one);               
            }
            else
            {
                this.transform.FindChild("model").gameObject.SetActive(true);
                this.transform.FindChild("model").transform.localScale = Vector3.one;
            }
        }

        if (trackerObj.isTriggerLost)
        {
            trackerObj.alreadyTriggered = true;
            this.transform.FindChild("model").gameObject.SetActive(false);
            trackerObj.isTriggered = false;
            trackerObj.isTriggerLost = false;
        }
    }

    void focus()
    {
        CameraDevice.Instance.SetFocusMode(CameraDevice.FocusMode.FOCUS_MODE_CONTINUOUSAUTO);
    }
}
